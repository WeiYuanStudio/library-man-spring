package club.piclight.libraryman.API;

import club.piclight.libraryman.Model.BookInfo;
import club.piclight.libraryman.Repository.BookInfoRepository;
import club.piclight.libraryman.ViewModel.Request.Book.UserSubmitBookInfo;
import club.piclight.libraryman.ViewModel.Response.Book.BookInfoForSearch;
import club.piclight.libraryman.ViewModel.StatusTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookInfoRepository bookInfoRepository;

    /**
     * 搜索书名
     * @param title
     * @return
     */
    @GetMapping("/api/books")
    private List<BookInfoForSearch> searchBookByTitleLike(@RequestParam("title") String title) {
        List<BookInfo> bookInfoList = bookInfoRepository.getBookInfoByTitleIsLike('%' + title + '%');
        List<BookInfoForSearch> responseInfoList = new ArrayList<>();
        bookInfoList.forEach(bookInfo -> {
            BookInfoForSearch tempInfo = new BookInfoForSearch();
            tempInfo.setBid(bookInfo.getBid());
            tempInfo.setIsbn(bookInfo.getIsbn());
            tempInfo.setTitle(bookInfo.getTitle());
            tempInfo.setAuthor(bookInfo.getAuthor());
            tempInfo.setCoverImg(bookInfo.getCoverImg());
            tempInfo.setIntro(bookInfo.getIntro());
            responseInfoList.add(tempInfo);
        });
        return responseInfoList;
    }

    @GetMapping("/api/bookinfo")
    private BookInfo getBookInfo(@RequestParam("bid")Long bid) {
        return bookInfoRepository.getBookInfoByBid(bid);
    }

    /**
     * 用户上传书本信息
     */
    @PostMapping("/api/book")
    private StatusTemplate userPostBookInfo(@RequestBody UserSubmitBookInfo bookInfo) {
        BookInfo tempBook = new BookInfo();
        tempBook.setIsbn(bookInfo.getIsbn());
        tempBook.setTitle(bookInfo.getTitle());
        tempBook.setAuthor(bookInfo.getAuthor());
        tempBook.setCoverImg(bookInfo.getCoverImg());
        tempBook.setIntro(bookInfo.getIntro());

        bookInfoRepository.save(tempBook);
        return new StatusTemplate(200, "Update book info success");
    }

    /**
     * 用户上传图片，送至图床
     */
}
