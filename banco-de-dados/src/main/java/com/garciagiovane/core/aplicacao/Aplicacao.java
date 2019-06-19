package com.garciagiovane.core.aplicacao;
import java.util.*;

import javax.swing.JOptionPane;

import com.garciagiovane.core.tema10.AgendaDAO;
import com.garciagiovane.core.tema10.Contato;

public class Aplicacao {
	public static void main(String[] args) {
		AgendaDAO agendaDAO = new AgendaDAO();
		Contato contato = new Contato();
		int op = 0;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada\n"
					+ "\n1 - Cadastrar Contato"
					+ "\n2 - Remover contato"
					+ "\n3 - Listar Contatos"
					+ "\n4 - Buscar contato por nome"
					+ "\n5 - Buscar contato por código"
					+ "\n6 - Listar contatos ordenado por onome ou código"
					+ "\n0 - Sair"));
			
			switch (op) {
			case 1:
				contato.setNome(JOptionPane.showInputDialog("Digite o nome"));
				contato.setTelefone(JOptionPane.showInputDialog("Digite o telefone"));
				contato.setEmail(JOptionPane.showInputDialog("Digite o email"));
				
				agendaDAO.cadastrarContato(contato);
				break;
			case 2:
				int codigoContatoParaRemocao = Integer.parseInt(JOptionPane.showInputDialog("Digite o código para remoção"));
				agendaDAO.removerContato(codigoContatoParaRemocao);
				break;
			case 3:
				List<Contato> contatosEncontrados = agendaDAO.listarContatos();
				for(Contato exibirContatos : contatosEncontrados) {
					System.out.println("Código: " + exibirContatos.getIdContato()
					+ "\nNome: " + exibirContatos.getNome()
					+ "\nTelefone: " + exibirContatos.getTelefone()
					+ "\nEmail: " + exibirContatos.getEmail() + "\n");
				}
				break;
			case 4:
				String nome = JOptionPane.showInputDialog("Digite o nome");
				String parametro = "nome LIKE '" + nome + "%'";
				contatosEncontrados = agendaDAO.buscarContatosPorParametro(parametro);
				
				for(Contato exibirContato : contatosEncontrados) {
					System.out.println("Nome: " + exibirContato.getNome()
					+ "\nTelefone: " + exibirContato.getTelefone()
					+ "\nEmail: " + exibirContato.getEmail() + "\n");
				}
				break;
			case 5:
				int idContato = Integer.parseInt(JOptionPane.showInputDialog("Digite o código"));
				parametro = "idContato = " + idContato;
				contatosEncontrados = agendaDAO.buscarContatosPorParametro(parametro);
				
				for(Contato exibirContato : contatosEncontrados) {
					System.out.println("Nome: " + exibirContato.getNome()
					+ "\nTelefone: " + exibirContato.getTelefone()
					+ "\nEmail: " + exibirContato.getEmail() + "\n");
				}
				break;
			case 6:
				int tipoOrdenacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção"
						+ "\nOrdenar por nome - 1"
						+ "\nOrdenar por código - 2"));
				String ordenacao;
				if (tipoOrdenacao == 1) {
					ordenacao = "ORDER BY nome";
				} else {
					ordenacao = "ORDER BY idContato";
				}
				
				contatosEncontrados = agendaDAO.listaOrdenada(ordenacao);				
								
				for(Contato exibirContato : contatosEncontrados) {
					
					System.out.println("Código: " + exibirContato.getIdContato()
							+ "\nNome: " + exibirContato.getNome()
					+ "\nTelefone: " + exibirContato.getTelefone()
					+ "\nEmail: " + exibirContato.getEmail() + "\n");
				}
				break;
			case 0:
				System.exit(1);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			
		} while (op != 0);

	}
	
}
