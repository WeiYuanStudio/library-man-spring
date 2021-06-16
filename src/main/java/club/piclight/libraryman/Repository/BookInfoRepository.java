package club.piclight.libraryman.Repository;

import club.piclight.libraryman.Model.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookInfoRepository extends JpaRepository<BookInfo, Long> {
    BookInfo getBookInfoByBid(Long bid);
    BookInfo getBookInfoByIsbn(String isbn);
    List<BookInfo> getBookInfoByTitleIsLike(String title);
}
