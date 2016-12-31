package diary;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/** 日記エンティティクラス */
@Entity
public class DiaryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** タイトル */
    @Id
    @NotNull
    private String title;

    /** 内容 */
    @NotNull
    private String text;

    /** 掲載日付 */
    @NotNull
    private Timestamp wrttingDate;

    /** デフォルトコンストラクタ */
    public DiaryEntity() {
    }

    /** 値設定コンストラクタ */
    public DiaryEntity(String title, String text,
            Timestamp date) {
        this.title = title;
        this.text = text;
        this.wrttingDate = date;
    }

    /** タイトル取得 */
    public String getTitle() {
        return title;
    }

    /** タイトル設定 */
    public void setTitle(String title) {
        this.title = title;
    }

    /** 内容取得 */
    public String getText() {
        return text;
    }

    /** 内容設定 */
    public void setText(String text) {
        this.text = text;
    }

    /** 掲載日付取得 */
    public Timestamp getDate() {
        return wrttingDate;
    }

    /** 掲載日付取得 */
    public void setDate(Timestamp date) {
        this.wrttingDate = date;
    }

}
