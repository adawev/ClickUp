package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Task;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckListDto {
    private String name;
    private Integer task;
}
