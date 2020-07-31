import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTicketTest {

    @Test
    void getRate() {
    }

    @Test
    void testToString() throws InterruptedException {
        ParkingTicket ticket = new ParkingTicket(3);
        TimeUnit.SECONDS.sleep(5);
        System.out.println(ticket.toString());
    }
}