package results;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/** 実績プロジェクトエンティティクラス */
@Entity
public class ResultsProjectsEntity
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /** プロジェクト名 */
    @Id
    @NotNull
    private String projectName;

    /** ステップ数 */
    @NotNull
    private int stepNum;

    /** デフォルトコンストラクタ */
    public ResultsProjectsEntity() {

    }

    /** 値設定コンストラクタ */
    public ResultsProjectsEntity(
            String projectName, int stepNum) {
        this.projectName = projectName;
        this.stepNum = stepNum;
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
    public int getStepNum() {
        return stepNum;
    }

    /** ステップ数取得 */
    public void setStepNum(int stepNum) {
        this.stepNum = stepNum;
    }

}
