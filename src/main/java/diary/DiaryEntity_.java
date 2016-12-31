package diary;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-05T23:55:49.277+0900")
@StaticMetamodel(DiaryEntity.class)
public class DiaryEntity_ {
	public static volatile SingularAttribute<DiaryEntity, String> title;
	public static volatile SingularAttribute<DiaryEntity, String> text;
	public static volatile SingularAttribute<DiaryEntity, Timestamp> wrttingDate;
}
