package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status, Integer> {
}
