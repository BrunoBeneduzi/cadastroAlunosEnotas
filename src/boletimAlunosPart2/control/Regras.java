package boletimAlunosPart2.control;

import java.util.List;
import java.util.stream.Collectors;
import alunos.Aluno;
import boletimAlunosPart2.arquivo.Arq;

public class Regras {
	Arq arq = new Arq();
	
	public boolean verificaAluno(String nome) {//verifica se o nome já existe na lista.
		try {
			var teste = arq.retornaAlunos().stream().filter(a -> a.getNome().equalsIgnoreCase(nome)).collect(Collectors.toList());
			return teste.isEmpty();		
		}catch(ArrayIndexOutOfBoundsException e) {
			return true;
		}
	}
	
	public void exibeDados() {//exibe os dados que estão no arquivo
		int codigo = 0;
		List<Aluno> alun = arq.retornaAlunos();
		for(Aluno aluno: alun ){
			codigo++;
			System.out.println("Codigo: "+codigo+" | "+ aluno);
		}
	}
	
	public boolean verificaNota0A10(String nota) {//verifica se a nota está entre 0 a 10
		Double notas = Double.parseDouble(nota);
		
		if(notas >= 0 && notas <= 10) {
			return true;
		}
		return false;
	}
}