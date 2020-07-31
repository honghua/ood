import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot {
    private final List<Level> levels;
    private final List<ParkingTicket> activeTickets; // → persist to disc

    public ParkingLot(int numOfLevels, int numSpotsPerLevel) {
        levels = new ArrayList<>();
        for (int i = 0; i < numOfLevels; i++) {
            levels.add(new Level(numSpotsPerLevel));
        }
        activeTickets = new ArrayList<>();
    }
    private static ParkingLot INSTANCE = null;
    public static ParkingLot getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ParkingLot(2, 50);
        }
        return INSTANCE;
    }

    public ParkingTicket getNewParkingTicket(Vehicle v) throws ParkingFullException {
        if (v == null) return null;
        if (!this.hasSpot(v)) {
            throw new ParkingFullException("Lot is full");
        }
        ParkingTicket ticket = new ParkingTicket(activeTickets.size());
        v.assignParkingTicket(ticket);
        return ticket;
    }

    public boolean hasSpot(Vehicle v) {
        for (Level l : levels) {
            if (l.hasSpot(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean park(Vehicle v) {
        if (v == null) return false;
        for (Level l: levels) {
            if (l.park(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean leave(Vehicle v) {
        if (v == null) return false;
        for (Level l : levels) {
            if (l.leave(v)) {
                return true;
            }
        }
        return false;
    }

    public BigDecimal pay(ParkingTicket ticket) {
        return ticket.getRate();
    }
}

class Level {
    private final List<ParkingSpot> spots;
    public Level(int numOfSpots) {
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        for (; i < numOfSpots/2; i++) {
            list.add(new ParkingSpot(VehicleSize.COMPACT));
        }
        for (; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.LARGE));
        }
        spots = Collections.unmodifiableList(list);
    }
    boolean hasSpot(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.fit(v)) {
                return true;
            }
        }
        return false;
    }
    boolean park(Vehicle v) {
        for (ParkingSpot s: spots) {
            if (s.fit(v)) {
                s.park(v);
                return true;
            }
        }
        return false;
    }
    boolean leave(Vehicle v) {
        for (ParkingSpot s: spots) {
            if (s.getVehicle() == v) {
                s.leave();
                return true;
            }
        }
        return false;
    }
}

class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;

    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    boolean fit(Vehicle v) {
        return currentVehicle == null && v.getSize().compareSize(size) == -1;
    }
    void park(Vehicle v) {
        currentVehicle = v;
    }
    void leave() {
        currentVehicle = null;
    }
    Vehicle getVehicle() {
        return currentVehicle;
    }
}

