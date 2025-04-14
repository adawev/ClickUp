package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.TimeTracked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTrackedRepo extends JpaRepository<TimeTracked, Integer> {
}
