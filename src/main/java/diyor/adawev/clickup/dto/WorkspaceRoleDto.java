package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Workspace;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspaceRoleDto {
    private Integer workspace;
    private String name;
    private String extends_role;
}
