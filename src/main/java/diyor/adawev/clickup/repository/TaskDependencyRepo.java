package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.dto.TaskDependencyDto;
import diyor.adawev.clickup.model.TaskDependency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDependencyRepo extends JpaRepository<TaskDependency, Integer> {
}
