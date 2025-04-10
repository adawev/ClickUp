package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Icon;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriorityDto {
    private String name;
    private Integer icon;
}
