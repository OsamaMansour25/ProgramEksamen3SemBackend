package dat3.programEksamen.api;

import dat3.programEksamen.dtos.HotelRequest;
import dat3.programEksamen.dtos.HotelResponse;
import dat3.programEksamen.entity.Hotel;
import dat3.programEksamen.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/hotels")
public class HotelController {
    HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping
    public List<HotelResponse> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public HotelResponse createHotel(@RequestBody HotelRequest hotelRequest) {
        return hotelService.createHotel(hotelRequest);
    }
    @GetMapping("/{id}")
    public HotelResponse getHotelById(@PathVariable int id){
        return hotelService.getHotelById(id);
    }
    @PutMapping("{id}")
    public HotelResponse updateHotel(@PathVariable int id, @RequestBody HotelRequest hotelRequest){
        return hotelService.updateHotel(hotelRequest, id);
    }
    @DeleteMapping("{id}")
    public void deleteReservation(@PathVariable int id){
        hotelService.deleteHotel(id);
    }
}
