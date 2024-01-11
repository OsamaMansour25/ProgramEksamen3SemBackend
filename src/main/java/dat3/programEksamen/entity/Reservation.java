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
@Table(name = "Reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    LocalDate reservationDate;
    int price;
    @ManyToOne
    private Room room;
    @ManyToOne
    private Guest guest;
    LocalDateTime created;
    LocalDateTime updated;
    @PrePersist
    public void onCreate() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updated = LocalDateTime.now();
    }
    }
