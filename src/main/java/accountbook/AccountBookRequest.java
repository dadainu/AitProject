package accountbook;

import java.util.HashMap;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/** 家計簿入力情報クラス */
@Named
@RequestScoped
public class AccountBookRequest {

    /** id */
    private Integer id = null;
    
    /** 登録日付 */
    @NotEmpty
    private String registrationDate = "";
    
    /** 用途 */
    @NotEmpty
    private String uses = "";
    
    /** 金額 */
    @NotNull
    private Integer money = null;
    
    /** 用途Map */
    private HashMap<String, String> usesItem = new HashMap<>();
        
    /** 家計簿エンティティクラス */
    private AccountBookEntity entity = new AccountBookEntity();

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
    public void setRegistrationDate(String registrationDate) {
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

    /** 用途取得 */
    public HashMap<String, String> getUsesItem() {
        return usesItem;
    }

    /** 用途設定 */
    public void setUsesItem(HashMap<String, String> usesItem) {
        this.usesItem = usesItem;
    }

    /** 家計簿エンティティ取得 */
    public AccountBookEntity getEntity() {
        return entity;
    }

    /** 家計簿エンティティ設定 */
    public void setEntity(AccountBookEntity entity) {
        this.entity = entity;
    }

    
}
