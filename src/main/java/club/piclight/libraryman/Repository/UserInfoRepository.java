package club.piclight.libraryman.Repository;

import club.piclight.libraryman.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo getUserInfoById(Long id);
    UserInfo getUserINfoByUserName(String name);
}
