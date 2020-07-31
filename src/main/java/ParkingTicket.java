import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingTicket {
    private final String id;
    private final static int PARKING_RATE = 5;
    private final LocalDateTime startTime;
    private LocalDateTime checkOutTime;
    private TicketStatus status; // paid, unpaid
    public ParkingTicket(int count) {
        startTime = LocalDateTime.now();
        id = startTime.getHour() + startTime.getMinute() + startTime.getSecond() + String.valueOf(count);
        status = TicketStatus.UNPAID;
    }
    public BigDecimal getRate() {
        checkOutTime = LocalDateTime.now();
        long seconds = startTime.until( checkOutTime, ChronoUnit.SECONDS );
        return BigDecimal.valueOf(PARKING_RATE * seconds);
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "id='" + id + '\'' +
                ", rate=" + getRate() +
                ", startTime=" + startTime +
                ", checkOutTime=" + checkOutTime +
                ", totalTime=" + startTime.until( checkOutTime, ChronoUnit.SECONDS ) +
                ", status=" + status +
                '}';
    }
}

