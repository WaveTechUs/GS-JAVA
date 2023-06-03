package util;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import armazenamento.Armazenamento;
import armazenamento.Armazenamento.Retorno;
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
//					cancelar();
					break;
				case 7:
//					cancelar();
					break;
				case 8:
//					cancelar();
					break;
				}
			}
		} while (opcao != 9);
	}

	private void cadastrarONG() {
		try {
			long cnpj = parseInt(showInputDialog("CNPJ (Sem pontuação)"));
			String nomeCliente = showInputDialog("Nome do cliente");
			String senha = showInputDialog("Senha");

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

		Retorno retorno = armazenamento.pesquisarOng(cnpj);

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
		String senhaNova = showInputDialog("Senha novo");
		
		Retorno retorno = armazenamento.alterarOng(cnpj, cnpjNovo, nomeNovo, senhaNova);
		if(retorno.ok) {
			showMessageDialog(null, "Ong alterada");
		}else {
			showMessageDialog(null, "Ong não encontrada");
		}
	}

	private void apagarONG() {
		long cnpj = parseInt(showInputDialog("CNPJ (Sem pontuação)"));
		
		Retorno retorno = armazenamento.apagarOng(cnpj);
		
		if(retorno.ok) {
			showMessageDialog(null, "Ong foi apagada");
		}else {
			showMessageDialog(null, "Ong não foi encontrada");
		}
	}
	
	private void cadastrarRestaurante() {
		try {
			long cnpj = parseInt(showInputDialog("CNPJ (Sem pontuação)"));
			String nomeCliente = showInputDialog("Nome do cliente");
			String senha = showInputDialog("Senha");

			
//			Restaurante restaurante = new Restaurante(nomeCliente, 0, senha, null, false, null, null)

//			if (armazenamento.adicionarOng(ong)) {
//				showMessageDialog(null, "Ong registrada com sucesso");
//			} else {
//				showMessageDialog(null, "Ong já registrada");
//			}

		} catch (NumberFormatException e) {
			showMessageDialog(null, "Opção inválida");
			return;
		}
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
