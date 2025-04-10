package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectUserRepo extends JpaRepository<ProjectUser, Integer> {
}
