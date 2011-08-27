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
	
	@JoinColumn(name="idusuario")
	private Usuario idusuario;
	
	
	@JoinColumn(name="idamigo")
	private Usuario idamigo;
	
	@Column
	private String recado;
	
	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

	public Usuario getIdamigo() {
		return idamigo;
	}

	public void setIdamigo(Usuario idamigo) {
		this.idamigo = idamigo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getRecado() {
		return recado;
	}

	public void setRecado(String recado) {
		this.recado = recado;
	}
	
	

}
