package club.piclight.libraryman.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    private Integer bookCoin;
    private Date registerDate;
    @Column(nullable = false, unique = true)
    private String mail;
    private String avatar;
    private String password;
    private String userGroup;
}
