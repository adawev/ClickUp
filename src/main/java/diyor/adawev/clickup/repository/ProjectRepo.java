package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
