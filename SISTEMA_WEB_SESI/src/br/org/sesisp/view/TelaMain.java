package br.org.sesisp.view;

import java.util.Scanner;


import br.org.sesisp.dao.CrudDAO;
import br.org.sesisp.model.Usuario;


public class TelaMain {
	
	public static void main(String[] args) {
		Usuario usuario1 = new Usuario();
		CrudDAO inserir_usuario = new CrudDAO();
		Scanner entrada = new Scanner(System.in);
		int opicao;
		do {
			
			System.out.println("1 - fazer o registro \n2 - mostrar");
			opicao = entrada.nextInt();
			switch (opicao) {
			case 1:
				System.out.println("nome para ser adicionado");
				String nome;
				nome = entrada.next();
				usuario1.setNome(nome);
				System.out.println("idade para ser adicionado");
				int id;
				id = entrada.nextInt();
				usuario1.setIdade(id);
				usuario1.setReuniao("temos disponibilidade em 9/11/2023, 10/11/2023, 13/11/2023 e 14/11/2023");
				System.out.println(usuario1.getReuniao());
				System.out.println("digite data da reuniao");
				String data;
				data = entrada.next();
				usuario1.setData(data);
				System.out.println("data adicionada com sucesso");
				
				System.out.println("nome: " + usuario1.getNome() + "\nidade: " + usuario1.getIdade() + "\ndata da reuniao: " + usuario1.getData());

				break;
			case 2:
			System.out.println("nome: " + usuario1.getNome() + "\nidade: " + usuario1.getIdade() + "\ndata da reuniao: " + usuario1.getData());
				break;
				

			default:
				break;
			}
		} while (opicao == 9);
	}
}
