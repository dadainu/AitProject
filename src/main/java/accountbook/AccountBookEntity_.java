package accountbook;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-04-26T11:29:41.140+0900")
@StaticMetamodel(AccountBookEntity.class)
public class AccountBookEntity_ {
	public static volatile SingularAttribute<AccountBookEntity, Integer> id;
	public static volatile SingularAttribute<AccountBookEntity, String> registrationDate;
	public static volatile SingularAttribute<AccountBookEntity, String> uses;
	public static volatile SingularAttribute<AccountBookEntity, Integer> money;
}
