package boletimAlunosPart2.menu;

import java.util.Scanner;
import boletimAlunosPart2.control.Controle;

public class Menu {
	Scanner sc = new Scanner(System.in);
	public void menu() {
		Controle controle = new Controle();
		
		int escolhe = -1;
		
		while(escolhe != 0) {
			System.out.print("Digite o que deseja fazer"
					+ "\n1- Cadastro de aluno e notas"
					+ "\n2- Exibir alunos e notas cadastradas"
					+ "\n3- editar nome"
					+ "\n4- editar nota"
					+ "\n0- SAIR"
					+ "\n -> ");
			escolhe = sc.nextInt();
			sc.nextLine();
			
			switch(escolhe) {
			case 1:
				System.out.print("Digite o nome e sobrenome do aluno -> ");
				String nome = sc.nextLine();
				System.out.print("Digite a nota 1 -> ");
				String nota1 = sc.nextLine();
				System.out.print("Digite a nota 2 -> ");
				String nota2 = sc.nextLine();
				System.out.print("Digite a nota 3 -> ");
				String nota3 = sc.nextLine();
				
				controle.cadastrarAlunoEnota(nome, nota1, nota2, nota3);
				break;
			case 2:
				try {//se a lista estiver vazia vai retornar um aviso relatando que a list está vazia
					controle.retonaDados();	
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Nenhum regitro encontrado");
				}
				break;
			case 3:
				controle.editaNome();	
				break;
			case 4:
				controle.editaNota();
				break;
			default:
			}
			separa();
		}		
	}
	
	public void separa() {
		System.out.println("**************************************************************");
	}
}