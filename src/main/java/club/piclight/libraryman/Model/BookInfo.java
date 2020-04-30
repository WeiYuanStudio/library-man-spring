package club.piclight.libraryman.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "book_info")
public class BookInfo {
    @Id
    private Long bid;
    private String isbn;
    private String title;
    private String author;
    private String coverImg;
    private String intro;
}
