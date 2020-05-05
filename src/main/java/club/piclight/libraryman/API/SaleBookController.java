package club.piclight.libraryman.API;

import club.piclight.libraryman.Model.SaleBook;
import club.piclight.libraryman.Repository.SaleBookRepository;
import club.piclight.libraryman.ViewModel.Request.UserSubmitSaleBookInfo;
import club.piclight.libraryman.ViewModel.StatusTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
public class SaleBookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaleBookController.class);

    @Autowired
    private SaleBookRepository saleBookRepository;

    @Autowired
    StringRedisTemplate redis;

    /**
     * 用户发布资源
     */
    @PostMapping("/api/salebook")
    public StatusTemplate postSaleBookInfo(@RequestBody UserSubmitSaleBookInfo saleBookInfo, @RequestHeader("Authorization") String authorization) {
        try {
            ValueOperations ops = redis.opsForValue();
            Long uid = Long.parseLong(Objects.requireNonNull(ops.get(authorization)).toString());

            SaleBook tempBook = new SaleBook();
            tempBook.setUid(uid);
            tempBook.setBid(saleBookInfo.getBid());
            tempBook.setPrice(saleBookInfo.getPrice());
            tempBook.setTitle(saleBookInfo.getTitle());
            tempBook.setIntro(saleBookInfo.getIntro());
            tempBook.setSecretLink(saleBookInfo.getSecretLink());
            saleBookRepository.save(tempBook);

            return new StatusTemplate(200, "Submit sale book info success");
        } catch (NullPointerException e) {
            LOGGER.error("Uer submit sale book failed, cause Authorization not found");
            LOGGER.error(e.getMessage());

            return new StatusTemplate(401, "Authorization not found");
        } catch (Exception e) {
            return new StatusTemplate(500, "Submit sale book info failed");
        }
    }
}
