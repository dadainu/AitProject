package diary;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;

/** 日記アクションクラス */
@Singleton
public class DiaryAction implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 日記入力情報 */
    @Inject
    private DiaryRequest request;

    /** 日記出力情報 */
    @Inject
    private DiaryResponse response;

    /** 日記DAOクラス */
    @EJB
    private DiaryDbAccess db;

    /** データ全件取得 */
    public void setGetAll() {
        try {
            response.setListEntitys(db.getAll());
        } catch (Exception e) {
            System.err.println("データ取得失敗");
        }
    }

    /** 日記登録 */
    public void insertDbDiary() {
        try {
            db.insert(new DiaryEntity(
                    request.getTitle(),
                    request.getText(),
                    request.getDate()));
        } catch (Exception e) {
            System.err.println("DBへの登録に失敗");
        }
    }

    /** 日記1件取得 */
    public void selectDiary(DiaryEntity entity) {
        DiaryEntity localEntity = db
                .select(entity.getTitle());
        response.setTitle(localEntity.getTitle());
        response.setText(localEntity.getText());
    }

}
