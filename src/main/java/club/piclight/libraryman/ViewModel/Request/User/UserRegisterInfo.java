package club.piclight.libraryman.ViewModel.Request.User;

import lombok.Data;

/**
 * 用户注册信息VM
 */

@Data
public class UserRegisterInfo {
    private String userName;
    private String mail;
    private String password;
}
