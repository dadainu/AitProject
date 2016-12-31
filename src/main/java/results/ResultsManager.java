package results;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/** 実績マネージャクラス */
@Named
@RequestScoped
public class ResultsManager {
    
    /** 実績アクションクラス */
    @Inject
    private ResultsAction action;
    
    /** main遷移 */
    public String nextMain() {
        action.booksProjectsGetAll();
        return "/results/ResultsMain.xhtml";
    }
    
    /** 書籍名登録画面遷移 */
    public String nextBooksRegiatration() {
        
        return "ResultsBooksRegistration.xhtml";
    }
    
    /** プロジェクト名登録画面遷移 */
    public String nextProjectRegiatration() {
        
        return "ResultsProjectsRegistration.xhtml";
    }
    
    /** 書籍登録確認画面遷移 */
    public String nextBooksComfirmation() {
        action.setBookComfirmation();
        return "ResultsBooksComfirmation.xhtml";
    }
    
    /** プロジェクト登録確認画面遷移 */
    public String nextProjectsComfirmation() {
        action.setProjectConmfirmation();
        return "ResultsProjectsComfirmation.xhtml";
    }
    
    /** 書籍完了画面遷移 */
    public String nextBookCompletion() {
        action.insertBook();
        return "ResultsBooksCompletion.xhtml";
    }

    /** プロジェクト完了画面遷移 */
    public String nextProjectCompletion() {
        action.insertProject();
        return "ResultsProjectsCompletion.xhtml";
    }
    
    /** 実績確認画面遷移 */
    public String nextResultsList() {
        action.booksProjectsGetAll();
        return "ResultsList.xhtml";
    }
    
    /** 実績書籍編集画面遷移 */
    public String nextBooksEdit(ResultsBooksEntity entity) {
        action.setBookEdit(entity);
        return "ResultsBooksEdit.xhtml";
    }
    
    /** 実績プロジェクト編集画面遷移 */
    public String nextProjectsEdit(ResultsProjectsEntity entity) {
        action.setProjectEdit(entity);
        return "ResultsProjectsEdit.xhtml";
    }
    
    /** 実績書籍編集確認画面遷移 */
    public String nextBooksEditCompletion() {
        action.updateBook();
        return "ResultsBooksEditCompletion.xhtml";
    }

    /** 実績プロジェクト編集確認画面遷移 */
    public String nextProjectsEditCompletion() {
        action.updateProject();
        return "ResultsProjectEditCompletion.xhtml";
    }
}
