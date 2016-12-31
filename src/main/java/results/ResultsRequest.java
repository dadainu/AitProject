package results;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/** 実績入力情報クラス */
@Named
@RequestScoped
public class ResultsRequest {
    
    /** 書籍名 */
    @NotEmpty
    private String bookName = ""; 
    
    /** ページ数 */
    @NotNull
    private Integer pageCount = null;
    
    /** プロジェクト名 */
    @NotEmpty
    private String projectName = "";
    
    /** ステップ数 */
    @NotNull
    private Integer stepCount = null;

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

    /** プロジェクト名取得 */
    public String getProjectName() {
        return projectName;
    }

    /** プロジェクト名設定 */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /** ステップ数取得 */
    public Integer getStepCount() {
        return stepCount;
    }

    /** ステップ数設定 */
    public void setStepCount(Integer stepCount) {
        this.stepCount = stepCount;
    }    

}
