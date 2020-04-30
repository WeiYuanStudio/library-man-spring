package club.piclight.libraryman.API;

import club.piclight.libraryman.Model.BookInfo;
import club.piclight.libraryman.Repository.BookInfoRepository;
import club.piclight.libraryman.ViewModel.Response.Book.BookInfoForSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookInfoRepository bookInfoRepository;

    @GetMapping("/api/books")
    private List<BookInfoForSearch> searchBookByTitleLike(@RequestParam("title") String title) {
        List<BookInfo> bookInfoList = bookInfoRepository.getBookInfoByTitleLike(title);
        List<BookInfoForSearch> responseInfoList = new ArrayList<>();
        bookInfoList.forEach(bookInfo -> {
            BookInfoForSearch tempInfo = new BookInfoForSearch();
            tempInfo.setIsbn(bookInfo.getIsbn());
            tempInfo.setTitle(bookInfo.getTitle());
            tempInfo.setAuthor(bookInfo.getAuthor());
            tempInfo.setCoverImg(bookInfo.getCoverImg());
            tempInfo.setIntro(bookInfo.getIntro());
            responseInfoList.add(tempInfo);
        });
        return responseInfoList;
    }
}
