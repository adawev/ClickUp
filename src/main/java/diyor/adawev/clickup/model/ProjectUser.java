package diyor.adawev.clickup.model;

import diyor.adawev.clickup.model.entity.Permission;
import diyor.adawev.clickup.model.entity.TaskPermission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Project project;
    @OneToMany
    private List<User> user;
    @Enumerated(EnumType.STRING)
    private TaskPermission permission=TaskPermission.TO_DO;
}
