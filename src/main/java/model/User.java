package model;

public class User {
	
	private Integer id;
	private String  nome;
	private String email;
	private String pais;
	public User(Integer id, String nome, String email, String pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.pais = pais;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + ", pais=" + pais + "]";
	}
	
	
}//end User
