package diyor.adawev.clickup.repository;

import diyor.adawev.clickup.model.WorkspacePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspacePermissionRepo extends JpaRepository<WorkspacePermission, Integer> {
}
