package accountbook;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AccountBookOG01
        implements Serializable {

    private static final long serialVersionUID = 1L;
    private String registrationDate = "";
    private String uses = "";
    private Integer money = null;
    private Boolean updateFlag = false;
    private Boolean deleteFlag = false;

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(
            String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Boolean getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(
            Boolean updateFlag) {
        this.updateFlag = updateFlag;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(
            Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
