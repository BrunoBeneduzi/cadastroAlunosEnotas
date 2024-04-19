package boletimAlunosPart2.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import alunos.Aluno;

public class Arq {
	private String path = "c:\\temp\\boletim2.txt";
	
	public Arq() {this.criaArquivo();}
	
	public void criaArquivo() {//cria um arquivo no local especificado, caso não exista
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastraAlunoEnota(Aluno aluno) {
		String lines = aluno.getNome()+","+aluno.getNota1()+","+aluno.getNota2()+","+aluno.getNota3();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
				bw.write(lines);
				bw.newLine();
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastraAlunoEnota(List<Aluno> aluno) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for(Aluno a : aluno) {
				bw.write(a.getNome()+","+a.getNota1()+","+a.getNota2()+","+a.getNota3());
				bw.newLine();
			}
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> retornaAlunos() {
		List<Aluno> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				
				String[] vect = line.split(",");
				String nome = vect[0];
				String nota1 = vect[1];
				String nota2 = vect[2];
				String nota3 = vect[3];
				
				Aluno aluno = new Aluno(nome, nota1, nota2, nota3);
				list.add(aluno);
				
				line = br.readLine();
			}			
			return list;
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return null;
	}
}