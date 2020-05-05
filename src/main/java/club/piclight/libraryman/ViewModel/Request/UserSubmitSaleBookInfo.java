package club.piclight.libraryman.ViewModel.Request;

import lombok.Data;

@Data
public class UserSubmitSaleBookInfo {
    private Long bid; //出售书本信息bid
    private Integer price; //bookCoin售价
    private String title; //出售标题
    private String intro; //出售介绍
    private String secretLink; //出售密码链接
}
