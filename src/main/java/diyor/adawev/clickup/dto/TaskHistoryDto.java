package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Task;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskHistoryDto {
    private Integer task_id;
    private String change_field_name;
    private String before;
    private String after;
    private String data;
}
