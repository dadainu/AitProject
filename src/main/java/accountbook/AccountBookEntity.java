package accountbook;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/** 家計簿エンティティクラス */
@Entity
public class AccountBookEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    @Id
    @NotNull
    private Integer id;

    /** 登録日付 */
    @NotNull
    private String registrationDate;

    /** 用途 */
    @NotNull
    private String uses;

    /** 金額 */
    @NotNull
    private Integer money;

    /** デフォルトコンストラクタ */
    public AccountBookEntity() {
    }

    /** 値設定コンストラクタ */
    public AccountBookEntity(Integer id, String registrationDate, String uses, Integer money) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.uses = uses;
        this.money = money;
    }

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

}
