package club.piclight.libraryman.Repository;

import club.piclight.libraryman.Model.BookInfo;
import club.piclight.libraryman.Model.SaleBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleBookRepository extends JpaRepository<SaleBook, Long> {
    List<SaleBook> getBookInfoByTitleIsLike(String title);
    List<SaleBook> getBookInfoByBid(Long bid);
}
