package ong;

public class ONG {
	private int id;
	private String nome;
	private String cnpj;
	private String senha;
	
	public ONG(int id, String nome, String cnpj, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
