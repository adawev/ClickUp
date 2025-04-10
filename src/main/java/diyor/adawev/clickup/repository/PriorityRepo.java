package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepo extends JpaRepository<Priority, Integer> {
}
