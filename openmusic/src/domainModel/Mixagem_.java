package domainModel;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-10-10T00:51:59.583-0200")
@StaticMetamodel(Mixagem.class)
public class Mixagem_ {
	public static volatile SingularAttribute<Mixagem, Integer> id;
	public static volatile SingularAttribute<Mixagem, Usuario> usuario;
	public static volatile SingularAttribute<Mixagem, Musica> musica;
	public static volatile SingularAttribute<Mixagem, String> arquivo;
}
