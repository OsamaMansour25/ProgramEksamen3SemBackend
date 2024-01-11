package dat3.programEksamen.api;

import dat3.programEksamen.dtos.RoomRequest;
import dat3.programEksamen.dtos.RoomResponse;
import dat3.programEksamen.dtos.UserRequest;
import dat3.programEksamen.dtos.UserResponse;
import dat3.programEksamen.entity.Room;
import dat3.programEksamen.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
