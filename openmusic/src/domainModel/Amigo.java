package domainModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="amigos")
public class Amigo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany
	@Column
	private int id;
	
	
	@JoinColumn(name="idamigo1")
	private Usuario idamigo1;
	
	@JoinColumn(name="idamigo2")
	private Usuario idamigo2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getIdAmigo1() {
		return idamigo1;
	}

	public void setIdAmigo1(Usuario idAmigo1) {
		this.idamigo1 = idAmigo1;
	}

	public Usuario getIdAmigo2() {
		return idamigo2;
	}

	public void setIdAmigo2(Usuario idAmigo2) {
		this.idamigo2 = idAmigo2;
	}
	
	
}
