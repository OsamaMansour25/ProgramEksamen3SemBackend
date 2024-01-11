package dat3.programEksamen.service;

import dat3.programEksamen.Repository.HotelRepository;
import dat3.programEksamen.dtos.HotelRequest;
import dat3.programEksamen.dtos.HotelResponse;
import dat3.programEksamen.entity.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        hotelResponse.setNumberOfRooms(hotel.getRooms().size());
        return hotelResponse;
    }
    public List<HotelResponse> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    public HotelResponse getHotelById(int id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hotel not found"));
        HotelResponse hotelResponse = convertToResponse(hotel);
        return hotelResponse;
    }
    public HotelResponse updateHotel(HotelRequest body, int id){
        Hotel editHotel = hotelRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hotel not found"));
        editHotel.setName(body.getName());
        editHotel.setStreet(body.getStreet());
        editHotel.setCity(body.getCity());
        editHotel.setZip(body.getZip());
        editHotel.setCountry(body.getCountry());
        editHotel.setUpdated(LocalDateTime.now());


        return new HotelResponse(hotelRepository.save(editHotel));
    }
    public void deleteHotel(int id) {
        Hotel deleteHotel = hotelRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hotel not found"));
        hotelRepository.delete(deleteHotel);
    }

}
