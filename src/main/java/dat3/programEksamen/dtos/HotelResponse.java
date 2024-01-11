package dat3.programEksamen.dtos;

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
    private LocalDateTime created;
    private LocalDateTime updated;
}

