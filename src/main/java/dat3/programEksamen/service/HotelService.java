package dat3.programEksamen.service;

import dat3.programEksamen.Repository.HotelRepository;
import dat3.programEksamen.entity.Hotel;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
