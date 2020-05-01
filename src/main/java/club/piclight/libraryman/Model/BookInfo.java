package club.piclight.libraryman.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_info")
public class BookInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bid;
    private String isbn;
    private String title;
    private String author;
    private String coverImg;
    private String intro;
}
