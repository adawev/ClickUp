package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Integer> {
}
