package armazenamento;

import java.util.ArrayList;

import alimentos.Alimentos;
import ong.Ong;
import restaurante.Restaurante;
import retorno.RetornoOng;
import retorno.RetornoRestaurante;

public class Armazenamento {
	private ArrayList<Ong> ongs = new ArrayList<>();
	private ArrayList<Restaurante> restaurantes = new ArrayList<>();

	public boolean adicionarOng(Ong ong) {
		RetornoOng itemPesquisado = pesquisarOng(ong.getCnpj());
		if (itemPesquisado.isOk()) {
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
				saida.setOk(true);
				saida.setDado(item);
			}

		}
		return saida;
	}

	public RetornoOng alterarOng(long cnpj, long cnpjNovo, String nomeNovo, String senhaNova) {
		RetornoOng saida = new RetornoOng();
		RetornoOng itemPesquisado = pesquisarOng(cnpj);

		if (itemPesquisado.isOk()) {
			Ong ong = itemPesquisado.getDado();
			ong.setCnpj(cnpjNovo);
			ong.setNome(nomeNovo);
			ong.setSenha(senhaNova);

			saida.setOk(true);
			saida.setDado(ong);
		} else {
			saida.setOk(false);
		}

		return saida;
	}

	public RetornoOng apagarOng(long cnpj) {
		RetornoOng saida = new RetornoOng();
		RetornoOng itemPesquisado = pesquisarOng(cnpj);

		if (itemPesquisado.isOk()) {
			ongs.remove(itemPesquisado.getDado());
			saida.setOk(true);
		} else {
			saida.setOk(false);
		}

		return saida;
	}

	public RetornoRestaurante pesquisarRestaurante(long cnpj) {
		RetornoRestaurante saida = new RetornoRestaurante();
		for (Restaurante item : restaurantes) {

			if (item.getCnpj() == cnpj) {
				saida.setOk(true);
				saida.setDado(item);
			}

		}
		return saida;
	}

	public boolean adicionarRestaurante(Restaurante restaurante) {
		RetornoRestaurante itemPesquisado = pesquisarRestaurante(restaurante.getCnpj());
		if (itemPesquisado.isOk()) {
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

		if (itemPesquisado.isOk()) {
			restaurantes.remove(itemPesquisado.getDado());
			saida.setOk(true);
		} else {
			saida.setOk(false);
		}

		return saida;
	}

	public RetornoRestaurante alterarRestaurante(long cnpj, long cnpjNovo, String nomeNovo, String senhaNova,
			String enderecoNovo, String descricaoNovo, double pesoNovo, boolean statusRetiradaBoolNova) {

		RetornoRestaurante saida = new RetornoRestaurante();
		RetornoRestaurante itemPesquisado = pesquisarRestaurante(cnpj);

		if (itemPesquisado.isOk()) {
			Restaurante restaurante = itemPesquisado.getDado();
			Alimentos alimentosNovo = new Alimentos(descricaoNovo, pesoNovo);
			restaurante.setCnpj(cnpjNovo);
			restaurante.setNome(nomeNovo);
			restaurante.setSenha(senhaNova);
			restaurante.setEndereco(enderecoNovo);
			restaurante.setStatusRetirada(statusRetiradaBoolNova);
			restaurante.setAlimentos(alimentosNovo);

			saida.setOk(true);
			saida.setDado(restaurante);
		} else {
			saida.setOk(false);
		}

		return saida;
	}
}
