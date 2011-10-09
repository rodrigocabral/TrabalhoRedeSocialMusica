package domainModel;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-10-07T23:49:32.473-0300")
@StaticMetamodel(Solicitacao.class)
public class Solicitacao_ {
	public static volatile SingularAttribute<Solicitacao, Integer> id;
	public static volatile SingularAttribute<Solicitacao, Usuario> solicitador;
	public static volatile SingularAttribute<Solicitacao, Usuario> solicitado;
}
