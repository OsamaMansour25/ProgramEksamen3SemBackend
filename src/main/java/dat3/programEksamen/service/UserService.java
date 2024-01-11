package dat3.programEksamen.service;

import dat3.programEksamen.Repository.UserRepository;
import dat3.programEksamen.dtos.RoomResponse;
import dat3.programEksamen.dtos.UserRequest;
import dat3.programEksamen.dtos.UserResponse;
import dat3.programEksamen.entity.Room;
import dat3.programEksamen.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserResponse createUser(UserRequest userRequest) {

        User newUser = new User();
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(userRequest.getPassword());
        userRepository.save(newUser);

        return convertToResponse(newUser);
    }
    public UserResponse convertToResponse(User user) {
    UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }
}
