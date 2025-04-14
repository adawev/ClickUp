package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskUserRepo extends JpaRepository<TaskUser, Integer> {
}
