package dat3.programEksamen.api;

import dat3.programEksamen.dtos.HotelRequest;
import dat3.programEksamen.dtos.HotelResponse;
import dat3.programEksamen.dtos.RoomResponse;
import dat3.programEksamen.entity.Room;
import dat3.programEksamen.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/rooms")
public class RoomController {
    RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @PostMapping
    public RoomResponse createRoom(@RequestParam int hotelId, @RequestBody Room room) {
       return roomService.createRoom(hotelId, room);
    }

}
