package diyor.adawev.clickup.model;

import diyor.adawev.clickup.model.entity.AccessType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;
    @OneToOne
    private Workspace workspace;
    @Column(nullable = false)
    private String initial_letter;
    @ManyToOne
    private Icon icon;
    @OneToOne
    private Attachment avatar_id;
    @ManyToOne
    private User owner;
    @Enumerated(EnumType.STRING)
    private AccessType accessType=AccessType.MEMBER;
}
