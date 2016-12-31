package accountbook;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/** 家計簿DAOクラス */
@Stateless
public class AccountBookDbAccess {

    /** エンティティマネージャクラス */
    @PersistenceContext(unitName = "DARProject")
    private EntityManager em;

    /** insert */
    public void create(AccountBookEntity accountBookEntity) {
        em.persist(accountBookEntity);
    }

    /** update */
    public void update(AccountBookEntity accountBookEntity) {
        em.merge(accountBookEntity);
    }

    /** select */
    public AccountBookEntity find(Integer id) {
        return em.find(AccountBookEntity.class, id);
    }

    /** delete */
    public void delete(AccountBookEntity accountBookEntity) {
        em.remove(em.merge(accountBookEntity));
    }

    /** 全件取得 */
    public List<AccountBookEntity> getAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AccountBookEntity> query = builder.createQuery(AccountBookEntity.class);
        Root<AccountBookEntity> root = query.from(AccountBookEntity.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }

}
