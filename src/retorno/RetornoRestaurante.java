package retorno;

import restaurante.Restaurante;

public class RetornoRestaurante extends Retorno{
	private Restaurante dado;
	
	public RetornoRestaurante() {
		super();
	}

	public RetornoRestaurante(boolean ok, Restaurante dado) {
		super(ok);
		this.dado = dado;
	}

	public Restaurante getDado() {
		return dado;
	}

	public void setDado(Restaurante dado) {
		this.dado = dado;
	}
}
