package alimentos;

public class Alimentos {
	private String descricao;
	private double peso;

	public Alimentos(String descricao, double peso) {
		super();
		this.descricao = descricao;
		this.peso = peso;
	}

	public String getDados() {
		String aux = "";
		aux += "Descricão dos alimentos: " + this.descricao + "\n";
		aux += "Peso(Kg) dos alimentos: " + this.peso + "\n";
		return aux;
	}
}
