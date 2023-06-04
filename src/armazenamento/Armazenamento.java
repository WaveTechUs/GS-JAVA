package armazenamento;

import java.util.LinkedList;

import alimentos.Alimentos;
import ong.Ong;
import restaurante.Restaurante;

public class Armazenamento {
	private LinkedList<Ong> ongs = new LinkedList<>();
	private LinkedList<Restaurante> restaurantes = new LinkedList<>();

	public static class RetornoOng {
		public boolean ok;
		public Ong dado;
	}

	public static class RetornoRestaurante {
		public boolean ok;
		public Restaurante dado;
	}

	public boolean adicionarOng(Ong ong) {
		RetornoOng itemPesquisado = pesquisarOng(ong.getCnpj());
		if (itemPesquisado.ok) {
			return false;
		}

		this.ongs.add(ong);

		if (ongs.contains(ong))
			return true;

		return false;
	}

	public RetornoOng pesquisarOng(long cnpj) {
		RetornoOng saida = new RetornoOng();
		for (Ong item : ongs) {

			if (item.getCnpj() == cnpj) {
				saida.ok = true;
				saida.dado = item;
			}

		}
		return saida;
	}

	public RetornoOng alterarOng(long cnpj, long cnpjNovo, String nomeNovo, String senhaNova) {
		RetornoOng saida = new RetornoOng();
		RetornoOng itemPesquisado = pesquisarOng(cnpj);

		if (itemPesquisado.ok) {
			Ong ong = itemPesquisado.dado;
			ong.setCnpj(cnpjNovo);
			ong.setNome(nomeNovo);
			ong.setSenha(senhaNova);

			saida.ok = true;
			saida.dado = ong;
		} else {
			saida.ok = false;
		}

		return saida;
	}

	public RetornoOng apagarOng(long cnpj) {
		RetornoOng saida = new RetornoOng();
		RetornoOng itemPesquisado = pesquisarOng(cnpj);

		if (itemPesquisado.ok) {
			ongs.remove(itemPesquisado.dado);
			saida.ok = true;
		} else {
			saida.ok = false;
		}

		return saida;
	}

	public RetornoRestaurante pesquisarRestaurante(long cnpj) {
		RetornoRestaurante saida = new RetornoRestaurante();
		for (Restaurante item : restaurantes) {

			if (item.getCnpj() == cnpj) {
				saida.ok = true;
				saida.dado = item;
			}

		}
		return saida;
	}

	public boolean adicionarRestaurante(Restaurante restaurante) {
		RetornoRestaurante itemPesquisado = pesquisarRestaurante(restaurante.getCnpj());
		if (itemPesquisado.ok) {
			return false;
		}

		this.restaurantes.add(restaurante);

		if (restaurantes.contains(restaurante))
			return true;

		return false;
	}

	public RetornoRestaurante apagarRestaurante(long cnpj) {
		RetornoRestaurante saida = new RetornoRestaurante();
		RetornoRestaurante itemPesquisado = pesquisarRestaurante(cnpj);

		if (itemPesquisado.ok) {
			restaurantes.remove(itemPesquisado.dado);
			saida.ok = true;
		} else {
			saida.ok = false;
		}

		return saida;
	}

	public RetornoRestaurante alterarRestaurante(long cnpj, long cnpjNovo, String nomeNovo, String senhaNova,
			String enderecoNovo, String descricaoNovo, double pesoNovo, boolean statusRetiradaBoolNova) {

		RetornoRestaurante saida = new RetornoRestaurante();
		RetornoRestaurante itemPesquisado = pesquisarRestaurante(cnpj);

		if (itemPesquisado.ok) {
			Restaurante restaurante = itemPesquisado.dado;
			Alimentos alimentosNovo = new Alimentos(descricaoNovo, pesoNovo);
			restaurante.setCnpj(cnpjNovo);
			restaurante.setNome(nomeNovo);
			restaurante.setSenha(senhaNova);
			restaurante.setEndereco(enderecoNovo);
			restaurante.setStatusRetirada(statusRetiradaBoolNova);
			restaurante.setAlimentos(alimentosNovo);

			saida.ok = true;
			saida.dado = restaurante;
		} else {
			saida.ok = false;
		}

		return saida;
	}
}
