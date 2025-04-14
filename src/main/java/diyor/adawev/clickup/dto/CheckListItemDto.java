package diyor.adawev.clickup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckListItemDto {
    private String name;
    private Integer checklist_id;
    private String resolved;
    private Integer user_id;
}
