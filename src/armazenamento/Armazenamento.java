package armazenamento;

import java.util.LinkedList;

import ong.Ong;

public class Armazenamento {
	private LinkedList<Ong> ongs = new LinkedList<>();
	
	public static class Retorno{
		public boolean ok;
		public Ong dado;
	}
		
	public boolean adicionarOng(Ong ong) {
		Retorno itemPesquisado = pesquisarOng(ong.getCnpj());
		if(itemPesquisado.ok) {
			return false;
		}
		
		this.ongs.add(ong);
		
		if(ongs.contains(ong))
			return true;
		
		return false;
	}
	
	public Retorno pesquisarOng(long cnpj) {
		Retorno saida = new Retorno();
		for(Ong item : ongs) {

		   if(item.getCnpj() == cnpj) {
			   saida.ok = true;
			   saida.dado = item;
		   }

		} 
		return saida;
	}
	
	public Retorno alterarOng(long cnpj, long cnpjNovo, String nomeNovo, String senhaNova) {
		Retorno saida = new Retorno();
		Retorno itemPesquisado= pesquisarOng(cnpj);
		
		if(itemPesquisado.ok) {
			Ong ong = itemPesquisado.dado;
			ong.setCnpj(cnpjNovo);
			ong.setNome(nomeNovo);
			ong.setSenha(senhaNova);
			
			saida.ok = true;
			saida.dado = ong;
		}else {
			saida.ok =false;			
		}
		
		return saida;
	}
	
	public Retorno apagarOng(long cnpj) {
		Retorno saida = new Retorno();
		Retorno itemPesquisado= pesquisarOng(cnpj);
		
		if(itemPesquisado.ok) {
			ongs.remove(itemPesquisado.dado);
			saida.ok = true;
		}else {
			saida.ok = false;
		}
		
		return saida;
	}
}
