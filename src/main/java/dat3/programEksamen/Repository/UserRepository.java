package dat3.programEksamen.Repository;

import dat3.programEksamen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
