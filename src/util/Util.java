package util;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.time.LocalTime;

import alimentos.Alimentos;
import armazenamento.Armazenamento;
import armazenamento.Armazenamento.RetornoOng;
import armazenamento.Armazenamento.RetornoRestaurante;
import ong.Ong;
import restaurante.Restaurante;

public class Util {
	Armazenamento armazenamento = new Armazenamento();

	public void menu() {
		boolean excecao;

		do {
			excecao = false;
			try {
				perguntaMenu();
			} catch (NumberFormatException e) {
				showMessageDialog(null, "Opção inválida");
				excecao = true;
			}
		} while (excecao);
	}

	private void perguntaMenu() {
		int opcao;

		do {
			opcao = parseInt(showInputDialog(gerarMenu()));
			if (opcao < 1 || opcao > 9) {
				showMessageDialog(null, "Opção inválida");
			} else {
				switch (opcao) {
				case 1:
					cadastrarONG();
					break;
				case 2:
					pesquisarONG();
					break;
				case 3:
					alterarONG();
					break;
				case 4:
					apagarONG();
					break;
				case 5:
					cadastrarRestaurante();
					break;
				case 6:
					pesquisarRestaurante();
					break;
				case 7:
					alterarRestaurante();
					break;
				case 8:
					apagarRestaurante();
					break;
				}
			}
		} while (opcao != 9);
	}

	private void cadastrarONG() {
		try {
			long cnpj = parseInt(showInputDialog("CNPJ (Sem pontuação)"));
			String nomeCliente = showInputDialog("Nome do cliente");
			stringVazia(nomeCliente);
			String senha = showInputDialog("Senha");
			stringVazia(senha);
			Ong ong = new Ong(nomeCliente, cnpj, senha);

			if (armazenamento.adicionarOng(ong)) {
				showMessageDialog(null, "Ong registrada com sucesso");
			} else {
				showMessageDialog(null, "Ong já registrada");
			}

		} catch (NumberFormatException e) {
			showMessageDialog(null, "Opção inválida");
			return;
		}
	}

	private void pesquisarONG() {
		long cnpj = parseInt(showInputDialog("CNPJ"));

		RetornoOng retorno = armazenamento.pesquisarOng(cnpj);

		if (retorno.ok) {
			Ong ong = retorno.dado;
			showMessageDialog(null, ong.getDados());
		} else {
			showMessageDialog(null, "Ong não encontrada");
		}
	}

	private void alterarONG() {
		long cnpj = parseInt(showInputDialog("CNPJ a ser alterado (Sem pontuação)"));
		long cnpjNovo = parseInt(showInputDialog("CNPJ novo (Sem pontuação)"));
		String nomeNovo = showInputDialog("Nome novo");
		stringVazia(nomeNovo);
		String senhaNova = showInputDialog("Senha novo");
		stringVazia(senhaNova);

		RetornoOng retorno = armazenamento.alterarOng(cnpj, cnpjNovo, nomeNovo, senhaNova);
		if (retorno.ok) {
			showMessageDialog(null, "Ong alterada");
		} else {
			showMessageDialog(null, "Ong não encontrada");
		}
	}

	private void apagarONG() {
		long cnpj = parseInt(showInputDialog("CNPJ (Sem pontuação)"));

		RetornoOng retorno = armazenamento.apagarOng(cnpj);

		if (retorno.ok) {
			showMessageDialog(null, "Ong foi apagada");
		} else {
			showMessageDialog(null, "Ong não foi encontrada");
		}
	}

	private void cadastrarRestaurante() {
		try {
			String nome = showInputDialog("Nome");
			stringVazia(nome);
			long cnpj = parseInt(showInputDialog("CNPJ (Sem pontuação)"));
			String senha = showInputDialog("Senha");
			stringVazia(senha);
			String endereco = showInputDialog("Endereco");
			stringVazia(endereco);
			String descricao = showInputDialog("Descrição dos alimentos");
			stringVazia(descricao);
			double peso = Double.parseDouble(showInputDialog("Peso(kg) dos alimentos"));
			int statusRetirada = parseInt(showInputDialog("Retirada disponível? (1) Sim  - (2) Não"));
			boolean statusRetiradaBool;

			if (statusRetirada == 1) {
				statusRetiradaBool = true;
			} else if (statusRetirada == 2) {
				statusRetiradaBool = false;
			} else {
				throw new NumberFormatException("Opção inválida");
			}

			Alimentos alimentos = new Alimentos(descricao, peso);
			Restaurante restaurante = new Restaurante(nome, cnpj, senha, statusRetiradaBool, alimentos, endereco);

			if (armazenamento.adicionarRestaurante(restaurante)) {
				showMessageDialog(null, "Restaurante registrado com sucesso");
			} else {
				showMessageDialog(null, "Restaurante já registrado");
			}

		} catch (NumberFormatException e) {
			showMessageDialog(null, "Opção inválida");
			return;
		}
	}

	private void pesquisarRestaurante() {
		long cnpj = parseInt(showInputDialog("CNPJ"));

		RetornoRestaurante retorno = armazenamento.pesquisarRestaurante(cnpj);

		if (retorno.ok) {
			Restaurante restaurante = retorno.dado;
			showMessageDialog(null, restaurante.getDados());
		} else {
			showMessageDialog(null, "Restaurante não encontrado");
		}
	}

	private void alterarRestaurante() {
		long cnpj = parseInt(showInputDialog("CNPJ a ser alterado (Sem pontuação)"));
		String nomeNovo = showInputDialog("Nome");
		stringVazia(nomeNovo);
		long cnpjNovo = parseInt(showInputDialog("CNPJ (Sem pontuação)"));
		String senhaNova = showInputDialog("Senha");
		stringVazia(senhaNova);
		String enderecoNovo = showInputDialog("Endereco");
		stringVazia(enderecoNovo);
		String descricaoNovo = showInputDialog("Descrição dos alimentos");
		stringVazia(descricaoNovo);
		double pesoNovo = Double.parseDouble(showInputDialog("Peso(kg) dos alimentos"));
		int statusRetirada = parseInt(showInputDialog("Retirada disponível? (1) Sim  - (2) Não"));
		boolean statusRetiradaBoolNovo;

		if (statusRetirada == 1) {
			statusRetiradaBoolNovo = true;
		} else if (statusRetirada == 2) {
			statusRetiradaBoolNovo = false;
		} else {
			throw new NumberFormatException("Opção inválida");
		}

		RetornoRestaurante retorno = armazenamento.alterarRestaurante(cnpj, cnpjNovo, nomeNovo, senhaNova, enderecoNovo,
				descricaoNovo, pesoNovo, statusRetiradaBoolNovo);
		if (retorno.ok) {
			showMessageDialog(null, "Restaurante alterado");
		} else {
			showMessageDialog(null, "Restaurante não encontrado");
		}
	}

	private void apagarRestaurante() {
		long cnpj = parseInt(showInputDialog("CNPJ (Sem pontuação)"));

		RetornoRestaurante retorno = armazenamento.apagarRestaurante(cnpj);

		if (retorno.ok) {
			showMessageDialog(null, "Restaurante foi apagado");
		} else {
			showMessageDialog(null, "Restaurante não foi encontrado");
		}
	}

	private void stringVazia(String input) {
		if (input.length() == 0)
			throw new NumberFormatException("Opção inválida");
	}

	private String gerarMenu() {
		String aux = "Reserva de Cargas\n";
		aux += "1. Cadastrar Ong\n";
		aux += "2. Pesquisar Ong\n";
		aux += "3. Alterar Ong\n";
		aux += "4. Apagar Ong\n";
		aux += "5. Cadastrar restaurante\n";
		aux += "6. Pesquisar restaurante\n";
		aux += "7. Alterar restaurante\n";
		aux += "8. Apagar restaurante\n";
		aux += "9. Encerrar programa\n";
		return aux;
	}
}
