import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import service.Service;

public class Programa {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		
		do {
			
   			System.out.println("\n1 - Cadastrar alunos \n2 - Listar alunos  \n3 - Listar apenas um aluno "
   					+ " \n4 - Atualizar alunos\n5 - Excluir alunos\n6 - Sair");
   			System.out.println("Digite uma opção: ");
   			
   			opcao = sc.nextInt();
   			
   			if (opcao == 1) {
   				Aluno a = new Aluno();
   				
   				System.out.println("Digite o nome do aluno: ");
   				a.setNome(sc.next());
   				
   				System.out.println("Digite o ra do aluno: ");
   				a.setRa(sc.next());
   				
   				System.out.println("Digite o curso do aluno: ");
   				a.setCurso(sc.next());
   				
   				Service.InserirAluno(a);
   			}
   			else if (opcao == 2) {
   				Service.ExibirAlunos();
   			}
   			else if (opcao == 3) {
   				System.out.println("Digite o ID do aluno que deseja mostrar: ");
   				Service.ExibirAluno(sc.nextInt());
   			}
   			else if (opcao == 4) {
   				int id; 
   				System.out.println("Digite o ID do aluno que deseja atualizar: ");
   				id = sc.nextInt();
   				Service.ExibirAluno(id);
   				
   				Aluno aluno = new Aluno();
   				
   				aluno.setId(id);
   				
   				System.out.println("Digite o novo nome do aluno: ");
   				aluno.setNome(sc.next());
   			
   				System.out.println("Digite o novo ra do aluno: ");
   				aluno.setRa(sc.next());
   				
   				System.out.println("Digite o novo curso do aluno: ");
   				aluno.setCurso(sc.next());
   				
   				Service.AtualizarAluno(aluno);
   			}
   			
   			else if(opcao == 5) {
   				int id;
   				String resp;
   				
   				System.out.println("Digite o ID do aluno que deseja excluir: ");
   				id = sc.nextInt();    	   				
   				Service.ExibirAluno(id);
   				
   				System.out.println("Tem certeza disso? ");
   				resp = sc.next().toUpperCase();
   				
   				if (resp.equals("SIM") || resp.equals("S")) {
   					Service.ExcluirAluno(id);
   				}
   			}
			
		} while (opcao != 6);
	}	
}