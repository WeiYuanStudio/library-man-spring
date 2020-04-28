package club.piclight.libraryman.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusTemplate {
    private Integer statusCode;
    private String message;
}
