package results;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/** 実績書籍エンティティクラス */
@Entity
public class ResultsBooksEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 書籍名 */
    @Id
    @NotNull
    private String bookName;

    /** ページ数 */
    @NotNull
    private Integer pageCount;

    /** デフォルトコンストラクタ */
    public ResultsBooksEntity() {
    }

    /** 値設定コンストラクタ */
    public ResultsBooksEntity(String bookName,
            Integer pageCount) {
        this.bookName = bookName;
        this.pageCount = pageCount;
    }

    /** 書籍名取得 */
    public String getBookName() {
        return bookName;
    }

    /** 書籍名設定 */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /** ページ数取得 */
    public Integer getPageCount() {
        return pageCount;
    }

    /** ページ数設定 */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

}
