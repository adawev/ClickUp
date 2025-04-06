package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Space;
import diyor.adawev.clickup.model.User;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpaceUserDto {
    private Integer space;
    private Integer member;
}
