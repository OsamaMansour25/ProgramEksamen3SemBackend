package dat3.programEksamen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int roomNumber;
    int numberOfBeds;
    int price;
    @ManyToOne
    private Hotel hotel;
    LocalDateTime created;
    LocalDateTime updated;

}
