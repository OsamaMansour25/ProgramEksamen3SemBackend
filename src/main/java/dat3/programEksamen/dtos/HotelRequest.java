package dat3.programEksamen.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRequest {
    private String name;
    private String street;
    private String city;
    private int zip;
    private String country;
}
