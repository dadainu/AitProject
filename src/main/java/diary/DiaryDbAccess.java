package diary;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/** 日記DAOクラス */
@Stateless
public class DiaryDbAccess {
    
    /** エンティティマネージャクラス */
    @PersistenceContext(unitName="DARProject")
    private EntityManager em;
    
    /** insert */
    public void insert(DiaryEntity entity) {
        em.persist(entity);
    }
    
    /** select */
    public DiaryEntity select(String title) {
        return em.find(DiaryEntity.class, title);
    }
    
    /** update */
    public void update(DiaryEntity entity) {
        em.merge(entity);
    }
    
    /** delete */
    public void delte(DiaryEntity entity) {
        em.remove(em.merge(entity));
    }
    
    /** 全件取得 */
    public List<DiaryEntity> getAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DiaryEntity> query = builder.createQuery(DiaryEntity.class);
        Root<DiaryEntity> root = query.from(DiaryEntity.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
}
