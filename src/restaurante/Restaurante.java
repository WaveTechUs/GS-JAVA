package restaurante;

import java.time.LocalTime;
import alimentos.Alimentos;
import endereco.Endereco;

public class Restaurante {
	private String nome;
	private int cnpj;
	private String senha;
	private LocalTime horaRetirada;
	private boolean statusRetirada;
	private Alimentos alimentos;
	private Endereco endereco;
	
	public Restaurante(String nome, int cnpj, String senha, LocalTime horaRetirada, boolean statusRetirada,
			Alimentos alimentos, Endereco endereco) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.senha = senha;
		this.horaRetirada = horaRetirada;
		this.statusRetirada = statusRetirada;
		this.alimentos = alimentos;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalTime getHoraRetirada() {
		return horaRetirada;
	}

	public void setHoraRetirada(LocalTime horaRetirada) {
		this.horaRetirada = horaRetirada;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
