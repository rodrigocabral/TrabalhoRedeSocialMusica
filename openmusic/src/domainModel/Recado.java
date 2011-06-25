package domainModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="recado")
public class Recado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@JoinColumn(name="idamigo")
	private int idamigo;
	
	@Column
	private String recado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAmigo() {
		return idamigo;
	}

	public void setIdAmigo(int idAmigo) {
		this.idamigo = idAmigo;
	}

	public String getRecado() {
		return recado;
	}

	public void setRecado(String recado) {
		this.recado = recado;
	}
	
	

}
