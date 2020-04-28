package club.piclight.libraryman.API;

import club.piclight.libraryman.Model.UserInfo;
import club.piclight.libraryman.Repository.UserInfoRepository;
import club.piclight.libraryman.ViewModel.StatusTemplate;
import club.piclight.libraryman.ViewModel.Request.User.UserRegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @PostMapping("/api/user/info")
    public StatusTemplate userRegister(@RequestBody UserRegisterInfo registerInfo) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(registerInfo.getUserName());
        userInfo.setMail(registerInfo.getMail());
        userInfo.setPassword(registerInfo.getPassword());

        try {
            userInfoRepository.save(userInfo);
            return new StatusTemplate(200, "Register Success");
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusTemplate(400, "Register info illegal");
        } finally {
            return new StatusTemplate(500, "Unknown error");
        }
    }
}
