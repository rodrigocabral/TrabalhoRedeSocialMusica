package domainModel;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-08-04T23:09:53.186-0300")
@StaticMetamodel(Solicitacao.class)
public class Solicitacao_ {
	public static volatile SingularAttribute<Solicitacao, Integer> id;
	public static volatile SingularAttribute<Solicitacao, Usuario> idsolicitador;
	public static volatile SingularAttribute<Solicitacao, Usuario> idsolicitado;
}
