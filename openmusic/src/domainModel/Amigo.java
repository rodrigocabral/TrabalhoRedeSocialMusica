package domainModel;


import javax.persistence.*;

@Entity
@Table(name="amigos")
public class Amigo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idamigo1")
	private Usuario amigo1;
	
	@ManyToOne
	@JoinColumn(name="idamigo2")
	private Usuario amigo2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setAmigo1(Usuario amigo1) {
		this.amigo1 = amigo1;
	}

	public Usuario getAmigo1() {
		return amigo1;
	}
	
	public void setAmigo2(Usuario amigo2) {
		this.amigo2 = amigo2;
	}

	public Usuario getAmigo2() {
		return amigo2;
	}
	
	
}
