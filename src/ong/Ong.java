package ong;

public class Ong {
	private String nome;
	private long cnpj;
	private String senha;

	public Ong(String nome, long cnpj, String senha) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.senha = senha;
	}

	public String getDados() {
		String aux = "";
		aux += "Nome: " + nome + "\n";
		aux += "CNPJ: " + cnpj + "\n";
		aux += "Senha: " + senha + "\n";
		return aux;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
