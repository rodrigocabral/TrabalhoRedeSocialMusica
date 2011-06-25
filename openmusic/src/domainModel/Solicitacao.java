package domainModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="solicitacoes")
public class Solicitacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idsolicitador")
	private Usuario idsolicitador;
	
	@ManyToOne
	@JoinColumn(name="idsolicitado")
	private Usuario idsolicitado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getIdSolicitador() {
		return idsolicitador;
	}

	public void setIdSolicitador(Usuario idsolicitador) {
		this.idsolicitador = idsolicitador;
	}

	public Usuario getIdSolicitado() {
		return idsolicitado;
	}

	public void setIdSolicitado(Usuario idsolicitado) {
		this.idsolicitado = idsolicitado;
	}
	
	
}
