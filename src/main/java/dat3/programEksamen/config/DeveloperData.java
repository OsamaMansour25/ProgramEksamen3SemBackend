package dat3.programEksamen.config;

import dat3.programEksamen.Repository.GuestRepository;
import dat3.programEksamen.Repository.HotelRepository;
import dat3.programEksamen.Repository.ReservationRepository;
import dat3.programEksamen.Repository.RoomRepository;
import dat3.programEksamen.entity.Hotel;
import dat3.programEksamen.entity.Room;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Random;

@Controller
public class DeveloperData implements ApplicationRunner {
    GuestRepository guestRepository;
    HotelRepository hotelRepository;
    ReservationRepository reservationRepository;
    RoomRepository roomRepository;

    public DeveloperData(GuestRepository guestRepository, HotelRepository hotelRepository, ReservationRepository reservationRepository,
                         RoomRepository roomRepository) {
        this.guestRepository = guestRepository;
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        setupHotels();
    }

    public void setupHotels() {
        Random random = new Random();
        for (int i = 0; i < 250; i++) {
            Hotel hotel = Hotel.builder()
                    .name("Hotel " + i)
                    .street("Street " + i)
                    .city("City " + i)
                    .zip(1000 + random.nextInt(9000)) // Forudsat danske postnumre
                    .country("Country " + i)
                    .created(LocalDateTime.now())
                    .updated(LocalDateTime.now())
                    .build();

            hotel = hotelRepository.save(hotel);

            int roomsToCreate = 10 + random.nextInt(31); // Mellem 10 og 40 værelser
            for (int j = 0; j < roomsToCreate; j++) {
                Room room = Room.builder()
                        .numberOfBeds(1 + random.nextInt(4)) // Mellem 1 og 4 senge
                        .price(500 + random.nextInt(1501)) // Antagelse: Pris mellem 500 og 2000
                        .hotel(hotel)
                        .created(LocalDateTime.now())
                        .updated(LocalDateTime.now())
                        .build();

                roomRepository.save(room);
            }
        }
    }
}
