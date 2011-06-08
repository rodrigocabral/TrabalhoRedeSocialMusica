package domainModel;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-06-07T16:38:29.430-0300")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Integer> id;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, String> sobrenome;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, String> sexo;
	public static volatile SingularAttribute<Usuario, Date> datanascimento;
	public static volatile SingularAttribute<Usuario, String> cidade;
	public static volatile SingularAttribute<Usuario, String> estado;
	public static volatile SingularAttribute<Usuario, String> pais;
}
