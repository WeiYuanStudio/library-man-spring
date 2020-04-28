package club.piclight.libraryman.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name", "mail"})})
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private Integer bookCoin;
    private Date birthDay;
    @Column(name = "mail")
    private String mail;
    private String password;
}