package club.piclight.libraryman.ViewModel.Response.Book;

import lombok.Data;

@Data
public class BookInfoForSearch {
    private String isbn;
    private String title;
    private String author;
    private String coverImg;
    private String intro;
}
