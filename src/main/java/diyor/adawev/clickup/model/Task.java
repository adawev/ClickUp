package diyor.adawev.clickup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToMany
    private List<Status> status;
    @ManyToMany
    private List<Category> category;
    @ManyToMany
    private List<Priority> priority;
    @CreatedDate
    private LocalDateTime started_date= LocalDateTime.now();
    @DateTimeFormat
    private LocalDateTime due_date;
    @Column(nullable = false)
    private Long estimate_time;
    @DateTimeFormat
    private LocalDateTime activated_date;


}
