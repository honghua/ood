import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingTicket {
    private final String id;
    private TicketStatus status; // paid, unpaid
    private final static int PARKING_RATE = 5;
    private final LocalDateTime startTime;
    private LocalDateTime checkOutTime;
    private long totalMinutes;

    public ParkingTicket(int count) {
        startTime = LocalDateTime.now();
        id = startTime.getHour() + startTime.getMinute() + startTime.getSecond() + String.valueOf(count);
        status = TicketStatus.UNPAID;
    }
    public BigDecimal getRate() {
//        status = TicketStatus.PAID;
        checkOutTime = LocalDateTime.now();
        totalMinutes = startTime.until(checkOutTime, ChronoUnit.MINUTES );
        return BigDecimal.valueOf(PARKING_RATE * totalMinutes);
    }

    @Override
    public String toString() {
        if (status == TicketStatus.UNPAID) {
            return "ParkingTicket{" +
                    "id='" + id + '\'' +
                    ", status=" + status +
                    ", startTime=" + startTime +
                    '}';
        } else {
            getRate();
            return "ParkingTicket{" +
                    "id='" + id + '\'' +
                    ", status=" + status +
                    ", startTime=" + startTime +
                    ", checkOutTime=" + checkOutTime +
                    ", totalTime=" + startTime.until( checkOutTime, ChronoUnit.SECONDS ) +
                    ", rate=" + getRate() +
                    '}';
        }
    }
}

