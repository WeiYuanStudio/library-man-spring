package club.piclight.libraryman.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class SaleBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long sbid; //销售书Id
    private Long uid; //出售者uid
    private Long bid; //出售书本信息bid
    private Integer price; //bookCoin售价
    private String title; //出售标题
    private String intro; //出售介绍
    private String secretLink; //出售密码链接
}
