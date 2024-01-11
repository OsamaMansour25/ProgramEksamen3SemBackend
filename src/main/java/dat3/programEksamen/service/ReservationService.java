package dat3.programEksamen.service;



import dat3.programEksamen.Repository.GuestRepository;
import dat3.programEksamen.Repository.ReservationRepository;
import dat3.programEksamen.Repository.RoomRepository;
import dat3.programEksamen.entity.Reservation;
import dat3.programEksamen.entity.Room;
import dat3.programEksamen.entity.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {


     ReservationRepository reservationRepository;
     RoomRepository roomRepository;
     GuestRepository guestRepository;
     public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository, GuestRepository guestRepository) {
         this.reservationRepository = reservationRepository;
         this.roomRepository = roomRepository;
         this.guestRepository = guestRepository;
     }

    public Reservation createReservation(int roomNumber, int guestId, LocalDate reservationDate) {
        Room room = roomRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new RuntimeException("Guest not found"));

        Reservation reservation = new Reservation();
        reservation.setReservationDate(reservationDate);
        reservation.setPrice(room.getPrice());
        reservation.setRoom(room);
        reservation.setGuest(guest);

        return reservationRepository.save(reservation);
    }
    public void deleteReservation(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
        reservationRepository.delete(reservation);
    }
}
