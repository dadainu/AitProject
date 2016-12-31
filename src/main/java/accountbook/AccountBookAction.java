package accountbook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;

/** 家計簿アクションクラス */
@Singleton
public class AccountBookAction implements Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id = null;

    /** 用途選択肢Map */
    private HashMap<String, String> usesItem = new HashMap<>();

    /** エンティティーリスト */
    private List<AccountBookEntity> listEntitys = new ArrayList<>();

    /** 出力グループ項目リスト */
    private List<AccountBookOG01> listOG01 = new ArrayList<>();

    /** 家計簿入力情報 */
    @Inject
    private AccountBookRequest request;

    /** 家計簿出力情報 */
    @Inject
    private AccountBookResponse response;

    /** 家計簿DAOクラス */
    @EJB
    private AccountBookDbAccess db;

    /** コンストラクタ */
    public AccountBookAction() {
        usesItem = new HashMap<>();
        listEntitys = new ArrayList<>();
    }

    /** 登録画面item設定 */
    public void registrationUseItemSet() {
        usesItem.put("娯楽", "娯楽");
        usesItem.put("家賃", "家賃");
        usesItem.put("食事", "食事");
        usesItem.put("公共料金", "公共料金");
        usesItem.put("収入", "収入");
        response.setUsesItem(usesItem);
    }

    /** 登録確認画面データ設定 */
    public void confirmationSet() {
        response.setRegistrationDate(request.getRegistrationDate());
        response.setUses(request.getUses());
        response.setMoney(request.getMoney());
    }

    /** 削除確認画面データ設定 */
    public void deleteConfirmationSet(AccountBookEntity entity) {
        request.setId(entity.getId());
        request.setRegistrationDate(entity.getRegistrationDate());
        request.setUses(entity.getUses());
        request.setMoney(entity.getMoney());
        response.setId(entity.getId());
        response.setRegistrationDate(entity.getRegistrationDate());
        response.setUses(entity.getUses());
        response.setMoney(entity.getMoney());
    }

    /** id自動採番 */
    public void nextCompletion() {
        List<Integer> idList = new ArrayList<>();

        for (AccountBookEntity abe : db.getAll()) {
            idList.add(abe.getId());
        }
        Collections.sort(idList);
        if (!idList.isEmpty()) {
            if (idList.get(idList.size() - 1) != null) {
                setId(idList.get(idList.size() - 1) + 1);
            }
        } else {
            setId(0);
        }
        try {
            db.create(new AccountBookEntity(id, request.getRegistrationDate(), request.getUses(),
                    request.getMoney()));
        } catch (Exception e) {
            System.err.println("データの登録に失敗");
        }
        response.setRegistrationDate(request.getRegistrationDate());
        response.setUses(request.getUses());
        response.setMoney(request.getMoney());
    }

    /** 対象データ削除 */
    public void nextDeleteCompletion() {
        try {
            db.delete(db.find(request.getId()));
        } catch (Exception e) {
            System.out.println("データの削除に失敗");
        }
        response.setRegistrationDate(request.getRegistrationDate());
        response.setUses(request.getUses());
        response.setMoney(request.getMoney());
    }

    /** 値初期化 */
    public void clean() {
        setId(null);
        setUsesItem(new HashMap<>());
        setListEntitys(null);
        setListOG01(new ArrayList<>());
        response.setRegistrationDate("");
        response.setUses("");
        response.setMoney(null);
        response.setUsesItem(usesItem);
        response.setListOG01(listOG01);
    }

    /** データ全件取得 */
    public void setAll() {
        try {
            response.setListEntitys(db.getAll());
        } catch (Exception e) {
            System.err.println("全件取得失敗");
        }
    }

    /** 入出金合計 */
    public void setMoneySum() {
        Integer sum = 0;
        for (AccountBookEntity abe : db.getAll()) {
            if ("Income".equals(abe.getUses())) {
                sum += abe.getMoney();
            } else {
                sum -= abe.getMoney();
            }
        }
        response.setMoney(sum);
    }

    /** id取得 */
    public Integer getId() {
        return id;
    }

    /** id設定 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 用途情報取得 */
    public HashMap<String, String> getUsesItem() {
        return usesItem;
    }

    /** 用途情報設定 */
    public void setUsesItem(HashMap<String, String> usesItem) {
        this.usesItem = usesItem;
    }

    /** エンティティリスト取得 */
    public List<AccountBookEntity> getListEntitys() {
        return listEntitys;
    }

    /** エンティティリスト設定 */
    public void setListEntitys(List<AccountBookEntity> listEntitys) {
        this.listEntitys = listEntitys;
    }

    /** 出力グループ項目リスト取得 */
    public List<AccountBookOG01> getListOG01() {
        return listOG01;
    }

    /** 出力グループ項目リスト設定 */
    public void setListOG01(List<AccountBookOG01> listOG01) {
        this.listOG01 = listOG01;
    }

    /** 目標金額設定 */
    public void setGoalMoney() {

    }

}
