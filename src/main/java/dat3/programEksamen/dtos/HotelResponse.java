package dat3.programEksamen.dtos;

import dat3.programEksamen.entity.Hotel;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelResponse {
    private int id;
    private String name;
    private String street;
    private String city;
    private int zip;
    private String country;
    private int numberOfRooms;
    private LocalDateTime created;
    private LocalDateTime updated;

    public HotelResponse(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.street = hotel.getStreet();
        this.city = hotel.getCity();
        this.zip = hotel.getZip();
        this.country = hotel.getCountry();
        this.numberOfRooms = hotel.getRooms().size();
    }
}

