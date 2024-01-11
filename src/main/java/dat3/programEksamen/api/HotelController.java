package dat3.programEksamen.api;

import dat3.programEksamen.service.HotelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    HotelService hotelService;
public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
}
}
