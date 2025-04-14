package diyor.adawev.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Task task;
    @Column(nullable = false)
    private String change_field_name;
    @Column(nullable = false)
    private String before;
    @Column(nullable = false)
    private String after;
    @Column(nullable = false)
    private String data;
}
