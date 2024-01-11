package dat3.programEksamen.api;

import dat3.programEksamen.entity.Reservation;
import dat3.programEksamen.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/api/reservations")
public class ReservationController {

    ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation createReservation(@RequestParam int roomId,
                                         @RequestParam int guestId,
                                         @RequestParam LocalDate reservationDate) {
        return reservationService.createReservation(roomId, guestId, reservationDate);
    }
    @DeleteMapping("{id}")
    public void deleteReservation(@PathVariable int id){
        reservationService.deleteReservation(id);
    }
}
