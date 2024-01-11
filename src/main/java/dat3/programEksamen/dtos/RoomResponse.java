package dat3.programEksamen.dtos;

import dat3.programEksamen.entity.Room;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {
    private int roomNumber;
    private int numberOfBeds;
    private int price;
    private String hotelName; // Antager, at du kun vil sende hotellets navn tilbage
    private LocalDateTime created;
    private LocalDateTime updated;

    // Du kan tilføje en constructor, der tager en Room entitet og udfylder DTO'en
    public RoomResponse(Room room) {
        this.roomNumber = room.getRoomNumber();
        this.numberOfBeds = room.getNumberOfBeds();
        this.price = room.getPrice();
        this.hotelName = room.getHotel().getName(); // Antager at hotel entiteten har en getName metode

    }
}

