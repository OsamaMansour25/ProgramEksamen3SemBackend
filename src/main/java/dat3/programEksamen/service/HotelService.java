package dat3.programEksamen.service;

import dat3.programEksamen.Repository.HotelRepository;
import dat3.programEksamen.dtos.HotelRequest;
import dat3.programEksamen.dtos.HotelResponse;
import dat3.programEksamen.entity.Hotel;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    public HotelResponse createHotel(HotelRequest hotelRequest) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelRequest.getName());
        hotel.setStreet(hotelRequest.getStreet());
        hotel.setCity(hotelRequest.getCity());
        hotel.setZip(hotelRequest.getZip());
        hotel.setCountry(hotelRequest.getCountry());
        Hotel savedHotel = hotelRepository.save(hotel);
        return convertToResponse(savedHotel);
    }
    private HotelResponse convertToResponse(Hotel hotel) {
        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setId(hotel.getId());
        hotelResponse.setName(hotel.getName());
        hotelResponse.setStreet(hotel.getStreet());
        hotelResponse.setCity(hotel.getCity());
        hotelResponse.setZip(hotel.getZip());
        hotelResponse.setCountry(hotel.getCountry());
        hotelResponse.setCreated(hotel.getCreated());
        hotelResponse.setUpdated(hotel.getUpdated());
        return hotelResponse;
    }
}
