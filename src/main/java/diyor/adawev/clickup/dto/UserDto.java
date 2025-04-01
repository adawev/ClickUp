package diyor.adawev.clickup.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String full_name;
    private String email;
    private String password;
    private String color;
    private String initial_letter;
    private Integer avatar_id;
}
