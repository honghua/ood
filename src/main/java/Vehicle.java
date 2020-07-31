public abstract class Vehicle {
    private ParkingTicket ticket = null;
    public abstract VehicleSize getSize();
    public void assignParkingTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
    public ParkingTicket getTicket() {
        return ticket;
    }
}

class Car extends Vehicle {
    @Override
    public VehicleSize getSize() {
        return VehicleSize.COMPACT;
    }
}

class Truck extends Vehicle {
    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }
}

