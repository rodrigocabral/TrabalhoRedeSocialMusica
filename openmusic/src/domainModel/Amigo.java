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
	@Column
	private int id;
	
	@Column
	private int idamigo1;
	
	@Column
	private int idamigo2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAmigo1() {
		return idamigo1;
	}

	public void setIdAmigo1(int idAmigo1) {
		this.idamigo1 = idAmigo1;
	}

	public int getIdAmigo2() {
		return idamigo2;
	}

	public void setIdAmigo2(int idAmigo2) {
		this.idamigo2 = idAmigo2;
	}
	
	
}
