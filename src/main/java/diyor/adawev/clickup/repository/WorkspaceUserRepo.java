package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.WorkspaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceUserRepo extends JpaRepository<WorkspaceUser, Integer> {

}
