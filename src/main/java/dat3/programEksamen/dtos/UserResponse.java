package dat3.programEksamen.dtos;

import dat3.programEksamen.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String email;

    // Konstruktor der tager en User-entitet og initialiserer UserResponse
    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
    }
}

