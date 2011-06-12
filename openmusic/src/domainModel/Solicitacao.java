package domainModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Solicitacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private int idsolicitador;
	
	@Column
	private int idsolicitado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSolicitador() {
		return idsolicitador;
	}

	public void setIdSolicitador(int idsolicitador) {
		this.idsolicitador = idsolicitador;
	}

	public int getIdSolicitado() {
		return idsolicitado;
	}

	public void setIdSolicitado(int idsolicitado) {
		this.idsolicitado = idsolicitado;
	}
	
	
}
