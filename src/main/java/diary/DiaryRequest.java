package diary;

import java.sql.Timestamp;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.validator.constraints.NotEmpty;

/** 日記入力情報クラス */
@Named
@RequestScoped
public class DiaryRequest {
    
    /** タイトル */
    @NotEmpty
    private String title = "";
    
    /** 内容 */
    @NotEmpty
    private String text = "";

    /** 掲載日付 */
    private Timestamp date = new Timestamp(System.currentTimeMillis());

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
        return date;
    }

    /** 掲載日付設定 */
    public void setDate(Timestamp date) {
        this.date = date;
    }

}
