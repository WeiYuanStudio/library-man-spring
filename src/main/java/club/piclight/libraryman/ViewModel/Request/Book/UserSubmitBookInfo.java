package club.piclight.libraryman.ViewModel.Request.Book;

import lombok.Data;

/**
 * 用户提交书籍信息
 */
@Data
public class UserSubmitBookInfo {
    private String isbn;
    private String title;
    private String author;
    private String coverImg;
    private String intro;
}
