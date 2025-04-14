package diyor.adawev.clickup.model;

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
public class CategoryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToMany
    private List<Category> category;
    @ManyToMany
    private List<User> user;
    @Enumerated(EnumType.STRING)
    private TaskPermission taskPermission = TaskPermission.TO_DO;
}
