package domainModel;


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
	private Usuario solicitador;
	
	@ManyToOne
	@JoinColumn(name="idsolicitado")
	private Usuario solicitado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Usuario getSolicitador() {
		return solicitador;
	}

	public void setSolicitador(Usuario solicitador) {
		this.solicitador = solicitador;
	}

	public Usuario getSolicitado() {
		return solicitado;
	}

	public void setSolicitado(Usuario solicitado) {
		this.solicitado = solicitado;
	}

}
