package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.model.Workspace;
import diyor.adawev.clickup.model.WorkspaceRole;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspaceUserDto {
    private Integer workspace_id;
    private Integer user_id;
    private Integer workspaceRole_id;
}
