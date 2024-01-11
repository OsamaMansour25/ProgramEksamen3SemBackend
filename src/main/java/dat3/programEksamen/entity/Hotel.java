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
@Table(name = "Hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String street;
    String city;
    int zip;
    String country;
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
