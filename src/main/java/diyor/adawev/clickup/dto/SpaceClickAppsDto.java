package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.ClickApp;
import diyor.adawev.clickup.model.Space;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpaceClickAppsDto {
    private Integer space;
    private Integer clickApp;
}
