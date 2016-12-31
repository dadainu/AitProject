package results;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/** 実績プロジェクトDAOクラス */
@Stateless
public class ResultsProjectsDbAccess {

    /** エンティティマネージャクラス */
    @PersistenceContext(unitName = "DARProject")
    private EntityManager em;

    /** insert */
    public void insert(ResultsProjectsEntity entity) {
        em.persist(entity);
    }

    /** select */
    public ResultsProjectsEntity select(String pName) {
        return em.find(ResultsProjectsEntity.class, pName);
    }

    /** update */
    public void update(ResultsProjectsEntity entity) {
        em.merge(entity);
    }

    /** delete */
    public void delete(ResultsProjectsEntity entity) {
        em.remove(entity);
    }

    /** 全件取得 */
    public List<ResultsProjectsEntity> getAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ResultsProjectsEntity> query = builder
                .createQuery(ResultsProjectsEntity.class);
        Root<ResultsProjectsEntity> root = query.from(ResultsProjectsEntity.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
}
