package domainModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String sobrenome;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@Column
	private String sexo;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date datanascimento;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
	@Column
	private String pais;
	
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	//set get id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//set get nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//set get sobrenome
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	//set getemail
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//set get senha
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//set get sexo
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	//set get datanascimento
	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) throws Exception{
		try{
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
		this.datanascimento = (java.util.Date)formatter.parse(datanascimento);
		System.out.println(this.datanascimento);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	

}
