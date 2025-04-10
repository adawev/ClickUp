package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Project;
import diyor.adawev.clickup.model.User;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectUserDto {
    private Integer project;
    private Integer user;
}
