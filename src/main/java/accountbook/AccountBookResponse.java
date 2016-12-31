package accountbook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/** 家計簿出力情報クラス */
@Named
@SessionScoped
public class AccountBookResponse
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id = null;

    /** 登録日付 */
    private String registrationDate = "";

    /** 用途 */
    private String uses = "";

    /** 金額 */
    private Integer money = null;

    /** エンティティリスト */
    private List<AccountBookEntity> listEntitys = new ArrayList<>();

    /** 用途Map */
    private HashMap<String, String> usesItem = new HashMap<>();

    /**  */
    private List<AccountBookOG01> listOG01 = new ArrayList<>();

    /** id取得 */
    public Integer getId() {
        return id;
    }

    /** id設定 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 登録日付取得 */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /** 登録日付設定 */
    public void setRegistrationDate(
            String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /** 用途取得 */
    public String getUses() {
        return uses;
    }

    /** 用途設定 */
    public void setUses(String uses) {
        this.uses = uses;
    }

    /** 金額取得 */
    public Integer getMoney() {
        return money;
    }

    /** 金額設定 */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /** 用途Map取得 */
    public HashMap<String, String> getUsesItem() {
        return usesItem;
    }

    /** 用途Map設定 */
    public void setUsesItem(
            HashMap<String, String> usesItem) {
        this.usesItem = usesItem;
    }

    /**  */
    public List<AccountBookOG01> getListOG01() {
        return listOG01;
    }

    /**  */
    public void setListOG01(
            List<AccountBookOG01> listOG01) {
        this.listOG01 = listOG01;
    }

    /** エンティティリスト取得 */
    public List<AccountBookEntity> getListEntitys() {
        return listEntitys;
    }

    /** エンティティリスト設定 */
    public void setListEntitys(
            List<AccountBookEntity> listEntitys) {
        this.listEntitys = listEntitys;
    }

}
