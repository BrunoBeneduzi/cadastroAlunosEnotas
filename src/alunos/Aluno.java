package alunos;

import java.util.Scanner;

import boletimAlunosPart2.control.Regras;

public class Aluno {
	private String nome, nota1, nota2, nota3;
	private Scanner sc = new Scanner(System.in);
	private Regras regra = new Regras();
	
	public Aluno(String nome, String nota1, String nota2, String nota3) {
		this.nome = nome;
		setNota1(nota1);
		setNota2(nota2);
		setNota3(nota3);
	}

	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public String getNota1() {return nota1;}

	public void setNota1(String nota1) {
		if(regra.verificaNota0A10(nota1)) {
			this.nota1 = nota1;
			
		}else {
			System.out.println("A nota deve ser entre 0 a 10, Nota foi alterada para 0");
			this.nota1 = "0";
		} 
	}

	public String getNota2() {return nota2;}

	public void setNota2(String nota2) {
		if(regra.verificaNota0A10(nota2)) {
			this.nota2 = nota2;
			
		}else {
			System.out.println("A nota deve ser entre 0 a 10, Nota foi alterada para 0");
			this.nota2 = "0";
		} 
	}

	public String getNota3() {return nota3;}

	public void setNota3(String nota3) {
		if(regra.verificaNota0A10(nota3)) {
			this.nota3 = nota3;
			
		}else {
			System.out.println("A nota deve ser entre 0 a 10, Nota foi alterada para 0");
			this.nota3 = "0";
		} 
	}

	public void setNotas() {
		String novaNota;
		
		System.out.println("para editar todas as notas digite 0"
				+ "\n1- Editar nota 1"
				+ "\n2- Editar nota 2"
				+ "\n3- Editar nota 3");
		int nota = sc.nextInt();
		sc.nextLine();
		
		switch(nota) {
		case 1:
			System.out.println("Digite a nova nota -> ");
			novaNota = sc.nextLine();
			setNota1(novaNota);
			break;
		case 2:
			System.out.println("Digite a nova nota -> ");
			novaNota = sc.nextLine();
			setNota2(novaNota);	 
			break;
		case 3:
			System.out.println("Digite a nova nota -> ");
			novaNota = sc.nextLine();
			setNota3(novaNota);
			break;
		case 0:
			System.out.println("Digite a nova nota 1 -> ");
			novaNota = sc.nextLine();
			setNota1(novaNota);
			
			System.out.println("Digite a nova nota 2 -> ");
			novaNota = sc.nextLine();
			setNota2(novaNota);
			
			System.out.println("Digite a nova nota 3 -> ");
			novaNota = sc.nextLine();
			setNota3(novaNota); 
			break;
		default:
			System.out.println("Codigo invalido");
		}
	}

	@Override
	public String toString() {
		return "Aluno [nome = " + nome + ", nota1 = " + nota1 + ", nota2 = " + nota2 + ", nota3 = " + nota3 + "]";
	}	
}