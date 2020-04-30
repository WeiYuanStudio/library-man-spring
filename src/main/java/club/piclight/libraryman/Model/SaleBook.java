package club.piclight.libraryman.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sale_book")
public class SaleBook {
    @Id
    private Long sbid; //销售书Id
    private Long uid; //出售者uid
    private String isbn; //isbn编码
    private Integer price; //bookCoin售价
    private String title; //出售标题
    private String intro; //出售介绍
    private String secretLink; //出售密码链接
}
