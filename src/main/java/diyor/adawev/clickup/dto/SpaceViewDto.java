package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Space;
import diyor.adawev.clickup.model.View;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpaceViewDto {
    private Integer space;
    private Integer view;
}
