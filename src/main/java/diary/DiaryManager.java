package diary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/** 日記マネージャクラス */
@Named
@RequestScoped
public class DiaryManager {

    /** 日記アクションクラス */
    @Inject
    private DiaryAction action;

    /** main遷移 */
    public String nextMain() {
        action.setGetAll();
        return "/diary/DiaryMain.xhtml";
    }

    /** writting遷移 */
    public String nextWritting() {
        return "DiaryWritting.xhtml";
    }

    /** 完了画面遷移 */
    public String nextCompletion() {
        action.insertDbDiary();
        action.setGetAll();
        return "DiaryMain.xhtml";
    }

    /** egit遷移 */
    public String nextEdit() {
        return "DiaryEdit.xhtml";
    }

    /** reading遷移 */
    public String nextReading(DiaryEntity entity) {
        action.selectDiary(entity);
        return "DiaryReading.xhtml";
    }
}
