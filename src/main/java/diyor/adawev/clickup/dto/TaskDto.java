package diyor.adawev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private String name;
    private String description;
    private Integer status;
    private Integer category;
    private Integer priority;
    private LocalDateTime due_date;
    private Long estimate_time;
    private LocalDateTime activated_date;
}
