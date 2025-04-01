package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
