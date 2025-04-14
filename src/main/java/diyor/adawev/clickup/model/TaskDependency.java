package diyor.adawev.clickup.model;

import diyor.adawev.clickup.model.entity.DependencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Task task;
    @Enumerated(EnumType.STRING)
    private DependencyType dependencyType = DependencyType.WAITING;
}
