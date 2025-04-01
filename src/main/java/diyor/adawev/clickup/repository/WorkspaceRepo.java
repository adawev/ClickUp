package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepo extends JpaRepository<Workspace, Integer> {
}
