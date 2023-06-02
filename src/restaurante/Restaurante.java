package restaurante;

import java.time.LocalTime;
import alimentos.Alimentos;
import endereco.Endereco;

public class Restaurante {
	private int id;
	private String nome;
	private String cnpj;
	private String senha;
	private LocalTime horaRetirada;
	private boolean statusRetirada;
	private Alimentos alimentos;
	private Endereco endereco;
	
	public Restaurante(int id, String nome, String cnpj, String senha, LocalTime horaRetirada, boolean statusRetirada,
			Alimentos alimentos, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.senha = senha;
		this.horaRetirada = horaRetirada;
		this.statusRetirada = statusRetirada;
		this.alimentos = alimentos;
		this.endereco = endereco;
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
