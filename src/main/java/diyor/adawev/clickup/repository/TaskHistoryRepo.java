package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskHistoryRepo extends JpaRepository<TaskHistory, Integer> {
}
