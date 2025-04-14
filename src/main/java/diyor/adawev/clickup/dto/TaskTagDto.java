package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Tag;
import diyor.adawev.clickup.model.Task;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor@NoArgsConstructor@Data
public class TaskTagDto {
    private Integer task_id;
    private Integer tag_id;

}
