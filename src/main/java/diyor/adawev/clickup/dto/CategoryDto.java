package diyor.adawev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private String name;
    private Integer project;
    private boolean achieved;
    private String color;
}
