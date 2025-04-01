package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Attachment;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IconDto {
    private Integer attachment;
    private String color;
    private String initial_letter;
}
