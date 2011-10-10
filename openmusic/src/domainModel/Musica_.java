package domainModel;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-10-10T00:47:39.038-0200")
@StaticMetamodel(Musica.class)
public class Musica_ {
	public static volatile SingularAttribute<Musica, Integer> id;
	public static volatile SingularAttribute<Musica, Usuario> usuario;
	public static volatile SingularAttribute<Musica, String> nome;
	public static volatile SingularAttribute<Musica, String> arquivo;
}
