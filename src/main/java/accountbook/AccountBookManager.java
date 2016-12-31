package accountbook;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/** 家計簿マネージャクラス */
@Named
@RequestScoped
public class AccountBookManager {

    /** 家計簿アクションクラス */
    @Inject
    private AccountBookAction action;

    /** main遷移 */
    public String nextMain() {
        action.setMoneySum();
        action.setAll();
        return "/accountbook/AccountBookMain.xhtml";
    }

    /** 登録画面遷移 */
    public String nextRegistration() {
        action.registrationUseItemSet();
        return "AccountBookRegistration.xhtml";
    }

    /** 確認画面遷移 */
    public String nextConfirmation() {
        action.confirmationSet();
        return "AccountBookConfirmation.xhtml";
    }

    /** 完了画面遷移 */
    public String nextCompletion() {
        action.nextCompletion();
        return "AccountBookCompletion.xhtml";
    }

    /** home遷移 */
    public String nextFromMainToHome() {
        return "/Home.xhtml";
    }

    /** 削除画面遷移 */
    public String nextEdit() {
        action.clean();
        action.setAll();
        return "AccountBookDelete.xhtml";
    }

    /** 削除確認画面遷移 */
    public String nextDeleteConfirmation(AccountBookEntity entity) {
        action.deleteConfirmationSet(entity);
        return "AccountBookDeleteConfirmation.xhtml";
    }

    /** 削除完了画面遷移 */
    public String nextDeleteCompletion() {
        action.nextDeleteCompletion();
        return "AccountBookDeleteCompletion.xhtml";
    }

    public String nextGoalRegistration() {
        action.setGoalMoney();
        return "AccountBookGoalRegistration.xhtml";
    }
}
