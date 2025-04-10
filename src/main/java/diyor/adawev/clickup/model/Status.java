package diyor.adawev.clickup.model;

import diyor.adawev.clickup.model.entity.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    private List<Project> project;
    @OneToMany
    private List<Category> category;
    @Column(nullable = false)
    private String color;
    @Enumerated(EnumType.STRING)
    private StatusType statusType=StatusType.OPEN;
}
