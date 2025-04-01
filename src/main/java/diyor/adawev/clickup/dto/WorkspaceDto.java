package diyor.adawev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspaceDto {
    private String name;
    private String color;
    private Integer owner;
    private String initial_letter;
    private Integer avatar;
}
