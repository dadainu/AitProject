package results;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/** 実績出力情報クラス */
@Named
@SessionScoped
public class ResultsResponse
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 書籍名 */
    private String bookName = "";

    /** ページ数 */
    private Integer pageCount = null;

    /** プロジェクト名 */
    private String projectName = "";

    /** ステップ数 */
    private Integer stepCount = null;

    /** 書籍エンティティリスト */
    private List<ResultsBooksEntity> booksEntitys = new ArrayList<>();

    /** プロジェクトエンティティリスト */
    private List<ResultsProjectsEntity> projectsEntitys = new ArrayList<>();

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
    public void setProjectName(
            String projectName) {
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

    /** 書籍エンティティリスト取得 */
    public List<ResultsBooksEntity> getBooksEntitys() {
        return booksEntitys;
    }

    /** 書籍エンティティリスト設定 */
    public void setBooksEntitys(
            List<ResultsBooksEntity> booksEntitys) {
        this.booksEntitys = booksEntitys;
    }

    /** プロジェクトエンティティリスト取得 */
    public List<ResultsProjectsEntity> getProjectsEntitys() {
        return projectsEntitys;
    }

    /** プロジェクトエンティティリスト取得 */
    public void setProjectsEntitys(
            List<ResultsProjectsEntity> projectsEntitys) {
        this.projectsEntitys = projectsEntitys;
    }

}
