package diyor.adawev.clickup.model;

import diyor.adawev.clickup.model.entity.AccessType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToMany
    private List<Project> project;
    @Enumerated(EnumType.STRING)
    private AccessType accessType=AccessType.MEMBER;
    @Column(nullable = false)
    private boolean achieved;
    @Column(nullable = false)
    private String color;
}
