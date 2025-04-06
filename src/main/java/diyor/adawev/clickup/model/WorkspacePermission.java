package diyor.adawev.clickup.model;

import diyor.adawev.clickup.model.entity.Permission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspacePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private WorkspaceRole workspaceRole;
    @Enumerated(EnumType.STRING)
    private Permission permission=Permission.READ;
}
