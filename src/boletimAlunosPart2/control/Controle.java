package boletimAlunosPart2.control;

import java.util.List;
import java.util.Scanner;

import alunos.Aluno;
import boletimAlunosPart2.arquivo.Arq;

public class Controle {
	private Arq arq = new Arq();
	private Regras regra = new Regras();
	private Scanner sc = new Scanner(System.in);
	
	
	public void cadastrarAlunoEnota(String nome, String nota1, String nota2, String nota3) {//faz o cadastro de novos alunos
		if(regra.verificaAluno(nome)) {//verifica se o aluno já foi cadastrado
			arq.cadastraAlunoEnota(new Aluno(nome, nota1, nota2, nota3));
			System.out.println("Aluno cadastrado");
		}else {
			System.out.println("Esse nome já existe ou já foi cadastrado");
		}
	}
	
	public void retonaDados() {regra.exibeDados();}
	
	public void editaNome() {
		List<Aluno> alun = arq.retornaAlunos();
		
		System.out.println("Digite o codigo do aluno que deseja alterar o nome");
		regra.exibeDados();
		System.out.print("-> ");
		int codigo = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Digite o novo nome -> ");
		String nome = sc.nextLine();
		
		if(regra.verificaAluno(nome)) {
			alun.get(codigo-1).setNome(nome);
			arq.cadastraAlunoEnota(alun);
			System.out.println("Novo nome cadastrado");
		}else {
			System.out.println("Nome já existe");
			System.out.println("*********************************************************************************************");
			editaNome();
		}
	}
	
	public void editaNota() {
		List<Aluno> alun = arq.retornaAlunos();
		
		System.out.println("Digite o codigo do aluno que deseja alterar a nota");
		regra.exibeDados();
		System.out.print("-> ");
		int codigo = sc.nextInt();
		sc.nextLine();
		
		alun.get(codigo-1).setNotas();
	    arq.cadastraAlunoEnota(alun);
	}
}