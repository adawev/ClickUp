package diyor.adawev.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttachmentDto {
    private String name;
    private String original_name;
    private String size;
    private String content_type;
}
