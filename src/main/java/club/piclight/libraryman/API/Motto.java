package club.piclight.libraryman.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Motto {
    @GetMapping("/api/motto")
    public static String getMotto() {
        return "Hello World!";
    }
}
