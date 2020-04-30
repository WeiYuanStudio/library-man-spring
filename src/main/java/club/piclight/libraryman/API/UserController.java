package club.piclight.libraryman.API;

import club.piclight.libraryman.Model.UserInfo;
import club.piclight.libraryman.Repository.UserInfoRepository;
import club.piclight.libraryman.ViewModel.Request.User.UserLogin;
import club.piclight.libraryman.ViewModel.StatusTemplate;
import club.piclight.libraryman.ViewModel.Request.User.UserRegisterInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    StringRedisTemplate redis;

    @PostMapping("/api/user/info")
    public StatusTemplate userRegister(@RequestBody UserRegisterInfo registerInfo) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(registerInfo.getUserName());
        userInfo.setBookCoin(200);
        userInfo.setMail(registerInfo.getMail());
        userInfo.setPassword(registerInfo.getPassword());

        try {
            userInfoRepository.save(userInfo);
            LOGGER.info("New user register");
            return new StatusTemplate(200, "Register Success");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Found user register failed");
            return new StatusTemplate(400, "Register info illegal");
        }
    }

    @PostMapping("/api/sessions")
    public HashMap<String, String> userLogin(@RequestBody UserLogin userLogin){
        UserInfo userInfo = userInfoRepository.getUserINfoByUserName(userLogin.getUserName());
        if (userInfo.getPassword().equals(userLogin.getPassword())) {
            String session = UUID.randomUUID().toString();
            ValueOperations ops = redis.opsForValue();
            ops.set(session, userInfo.getId().toString());

            HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("statusCode", "200");
            responseMap.put("session", session);
            return responseMap;
        } else {
            HashMap<String, String> responseMap = new HashMap<>();
            responseMap.put("statusCode", "401");
            return responseMap;
        }
    }
}
