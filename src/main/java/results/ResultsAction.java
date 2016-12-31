package results;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/** 実績アクションクラス */
@RequestScoped
public class ResultsAction {
    
    /** 実績入力情報クラス */
    @Inject
    private ResultsRequest request;
    
    /** 実績出力情報クラス */
    @Inject
    private ResultsResponse response;
    
    /** 実績書籍DAOクラス */
    @EJB
    private ResultsBooksDbAccess booksDbAccess;
    
    /** 実績プロジェクトDAOクラス */
    @EJB
    private ResultsProjectsDbAccess projectsDbAccess;
    
    /** 書籍確認画面データ設定 */
    public void setBookComfirmation() {
        response.setBookName(request.getBookName());
        response.setPageCount(request.getPageCount());
    }
    
    /** プロジェクト確認画面データ設定 */
    public void setProjectConmfirmation() {
        response.setProjectName(request.getProjectName());
        response.setStepCount(request.getStepCount());
    }
    
    /** 書籍データ登録 */
    public void insertBook() {
        try {
            booksDbAccess.insert(new ResultsBooksEntity(request.getBookName(),request.getPageCount()));
        } catch (Exception e) {
            System.err.println("データ登録失敗");
        }
    }
    /** プロジェクトデータ登録 */
    public void insertProject() {
        try {
            projectsDbAccess.insert(new ResultsProjectsEntity(request.getProjectName(), request.getStepCount()));
        } catch (Exception e) {
            System.err.println("データ登録失敗");
        }
    }
    
    /** 書籍プロジェクト全件取得 */
    public void booksProjectsGetAll() {
        try {
            response.setBooksEntitys(booksDbAccess.getAll());
            response.setProjectsEntitys(projectsDbAccess.getAll());
        } catch (Exception e) {
            System.err.println("全件取得失敗");
        }
    }
    
    /** 値初期化 */
    public void clean() {
        request = new ResultsRequest();
        response = new ResultsResponse();
    }
    
    /** 実績書籍編集画面値設定 */
    public void setBookEdit(ResultsBooksEntity entity) {
        ResultsBooksEntity localEntity = booksDbAccess.select(entity.getBookName());
        request.setBookName(localEntity.getBookName());
        request.setPageCount(localEntity.getPageCount());
        response.setBookName(localEntity.getBookName());
        response.setPageCount(localEntity.getPageCount());
    }
    
    /** 実績プロジェクト編集画面値設定 */
    public void setProjectEdit(ResultsProjectsEntity entity) {
        ResultsProjectsEntity localEntity = projectsDbAccess.select(entity.getProjectName());
        request.setProjectName(localEntity.getProjectName());
        request.setStepCount(localEntity.getStepNum());
        response.setProjectName(localEntity.getProjectName());
        response.setStepCount(localEntity.getStepNum());
    }
    
    /** 実績書籍更新 */
    public void updateBook() {
        booksDbAccess.update(booksDbAccess.select(request.getBookName()));
        response.setBookName(request.getBookName());
        response.setPageCount(request.getPageCount());
    }
    
    /** 実績プロジェクト更新 */
    public void updateProject() {
        projectsDbAccess.update(projectsDbAccess.select(request.getProjectName()));
        response.setProjectName(request.getProjectName());
        response.setStepCount(request.getStepCount());
    }
}
