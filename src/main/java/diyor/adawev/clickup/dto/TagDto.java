package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Workspace;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagDto {
    private String name;
    private String color;
    private Integer workspace_id;
}
