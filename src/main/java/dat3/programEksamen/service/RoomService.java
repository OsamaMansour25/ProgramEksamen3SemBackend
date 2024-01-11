package dat3.programEksamen.service;

import dat3.programEksamen.Repository.HotelRepository;
import dat3.programEksamen.Repository.RoomRepository;
import dat3.programEksamen.dtos.HotelRequest;
import dat3.programEksamen.dtos.HotelResponse;
import dat3.programEksamen.dtos.RoomResponse;
import dat3.programEksamen.entity.Hotel;
import dat3.programEksamen.entity.Room;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoomService {
     RoomRepository roomRepository;
     HotelRepository hotelRepository;
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }
    public RoomResponse createRoom(int hotelId, Room room) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found"));
        room.setPrice(130);
        room.setNumberOfBeds(2);

        room.setHotel(hotel);
      Room savedRoom = roomRepository.save(room);

        return convertToResponse(savedRoom);
    }
    public RoomResponse convertToResponse(Room room) {
        RoomResponse roomResponse = new RoomResponse();
        roomResponse.setHotelName(room.getHotel().getName());
        roomResponse.setPrice(room.getPrice());
        roomResponse.setNumberOfBeds(room.getNumberOfBeds());
        return roomResponse;
    }
}
