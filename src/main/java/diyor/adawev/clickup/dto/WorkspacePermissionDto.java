package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.WorkspaceRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspacePermissionDto {
    private Integer workspaceRole;
}
