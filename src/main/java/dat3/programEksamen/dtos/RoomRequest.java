package dat3.programEksamen.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomRequest {
    int numberOfBeds;
    int price;
}
