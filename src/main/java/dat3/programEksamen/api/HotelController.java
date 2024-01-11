package dat3.programEksamen.api;

import dat3.programEksamen.dtos.HotelRequest;
import dat3.programEksamen.dtos.HotelResponse;
import dat3.programEksamen.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/hotels")
public class HotelController {
    HotelService hotelService;
public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
}
    @PostMapping
    public HotelResponse createHotel(@RequestBody HotelRequest hotelRequest) {
        return hotelService.createHotel(hotelRequest);
    }

}
