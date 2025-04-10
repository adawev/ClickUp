package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Category;
import diyor.adawev.clickup.model.Project;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusDto {
    private String name;
    private Integer project;
    private Integer category;
    private String color;
}
