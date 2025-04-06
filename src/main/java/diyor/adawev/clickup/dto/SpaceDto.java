package diyor.adawev.clickup.dto;

import diyor.adawev.clickup.model.Icon;
import diyor.adawev.clickup.model.User;
import diyor.adawev.clickup.model.Workspace;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpaceDto {
    private String name;
    private String color;
    private Integer workspace;
    private String initial_letter;
    private Integer icon;
    private Integer avatar_id;
    private Integer owner;
}
