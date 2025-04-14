package diyor.adawev.clickup.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class TaskAttachmentDto {
    private Integer task_id;
    private Integer attachment_id;
    private boolean pin_over_image;
}
