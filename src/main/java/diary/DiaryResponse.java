package diary;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/** 日記出力情報クラス */
@Named
@SessionScoped
public class DiaryResponse
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /** タイトル */
    private String title;

    /** 内容 */
    private String text;

    /** エンティティリスト */
    private List<DiaryEntity> listEntitys;

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

    /** エンティティリスト取得 */
    public List<DiaryEntity> getListEntitys() {
        return listEntitys;
    }

    /** エンティティリスト設定 */
    public void setListEntitys(
            List<DiaryEntity> listEntitys) {
        this.listEntitys = listEntitys;
    }

}
