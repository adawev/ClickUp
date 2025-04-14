package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagRepo extends JpaRepository<TaskTag, Integer> {
}
