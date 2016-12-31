package results;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/** 実績書籍DAOクラス */
@Stateless
public class ResultsBooksDbAccess {

    /** エンティティマネージャクラス */
    @PersistenceContext(unitName = "DARProject")
    private EntityManager em;

    /** insert */
    public void insert(ResultsBooksEntity entity) {
        em.persist(entity);
    }

    /** select */
    public ResultsBooksEntity select(String name) {
        return em.find(ResultsBooksEntity.class, name);
    }

    /** update */
    public void update(ResultsBooksEntity entity) {
        em.merge(entity);
    }

    /** delete */
    public void delete(ResultsBooksEntity entity) {
        em.remove(em.merge(entity));
    }

    /** 全件取得 */
    public List<ResultsBooksEntity> getAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ResultsBooksEntity> query = builder.createQuery(ResultsBooksEntity.class);
        Root<ResultsBooksEntity> root = query.from(ResultsBooksEntity.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
}
