package alimentos;

public class Alimentos {
	private int id;
	private String descricao;
	private double peso;
	
	public Alimentos(int id, String descricao, double peso) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
