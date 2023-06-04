package restaurante;

import alimentos.Alimentos;

public class Restaurante {
	private String nome;
	private long cnpj;
	private String senha;
	private boolean statusRetirada;
	private Alimentos alimentos;
	private String endereco;

	public Restaurante(String nome, long cnpj, String senha, boolean statusRetirada, Alimentos alimentos,
			String endereco) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.senha = senha;
		this.statusRetirada = statusRetirada;
		this.alimentos = alimentos;
		this.endereco = endereco;
	}

	public String getDados() {
		String aux = "";
		String bool = statusRetirada == true ? "Disponível" : "Não disponível";

		aux += "Nome: " + nome + "\n";
		aux += "CNPJ: " + cnpj + "\n";
		aux += "Senha: " + senha + "\n";
		aux += "Status da retirada: " + bool + "\n";
		aux += "Endereço: " + endereco + "\n";
		aux += alimentos.getDados();
		return aux;
	}

	public String getNome() {
		return nome;
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

	public boolean isStatusRetirada() {
		return statusRetirada;
	}

	public void setStatusRetirada(boolean statusRetirada) {
		this.statusRetirada = statusRetirada;
	}

	public Alimentos getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(Alimentos alimentos) {
		this.alimentos = alimentos;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
