package retorno;

import ong.Ong;

public class RetornoOng extends Retorno {
	private Ong dado;
	
	public RetornoOng(){
		super();
	}

	public RetornoOng(boolean ok, Ong dado) {
		super(ok);
		this.dado = dado;
	}
	
	public Ong getDado() {
		return dado;
	}

	public void setDado(Ong dado) {
		this.dado = dado;
	}

}
