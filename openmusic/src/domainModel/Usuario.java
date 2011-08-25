package domainModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
	@Column
	private String pais;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date datanascimento;
	

	
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

	public void setDatanascimento(String datanasc) throws Exception{
		try{
	           Pattern expressao = Pattern.compile("^(([0-2]\\d)|3[01])\\/(0[1-9]|1[0-2])\\/\\d{4}");
	           Matcher martch = expressao.matcher(datanasc);
	           if(martch.matches()){
	               SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	               java.util.Date dataUtil = df.parse(datanasc);
	               this.datanascimento = dataUtil;
	           }
	      }catch(Exception e){
	         e.getMessage();
	      }
	}

	

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}
	
	

}
