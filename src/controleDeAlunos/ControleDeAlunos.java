package controleDeAlunos;

import java.util.Scanner;

public class ControleDeAlunos {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcao;
		Controlador menu = new Controlador();
		
		do {
			System.out.print("(C)adastrar Aluno\n"
						+ "(E)xibir Aluno\n"
						+ "(N)ovo Grupo\n"
						+ "(A)locar Aluno no Grupo e Imprimir Grupos\n"
						+ "(R)egistrar Aluno que Respondeu\n"
						+ "(I)mprimir Alunos que Responderam\n"
						+ "(O)ra, vamos fechar o programa!\n"
						+ "\n"
						+ "Opção>");
			
			opcao = sc.nextLine().toUpperCase();
			System.out.println();
			
			if (opcao.equals("C")) {
				System.out.print("Matrícula: ");
				int matricula = sc.nextInt();
				sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Curso: ");
				String curso = sc.nextLine();
				
				System.out.println(menu.cadastroDeAluno(matricula, nome, curso));
			}
			
			else if (opcao.equals("E")) {
				System.out.print("Matricula: ");
				int matricula = sc.nextInt();
				sc.nextLine();
				
				System.out.println(menu.consultarAluno(matricula));
			}
			
			else if (opcao.equals("N")) {
				System.out.print("Grupo: ");
				String nomeDoGrupo= sc.nextLine();
				
				System.out.println(menu.cadastrarGrupo(nomeDoGrupo));
			}
			
			else if (opcao.equals("A")) {
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				opcao = sc.nextLine().toUpperCase();
				
				if (opcao.equals("A")) {
					System.out.print("Matrícula: ");
					int matricula = sc.nextInt();
					sc.nextLine();
					
					System.out.print("Grupo: ");
					String nomeDoGrupo = sc.nextLine();
					
					System.out.println(menu.alocarAluno(matricula, nomeDoGrupo));
					
				}
				
				else if (opcao.equals("I")) {
					System.out.print("Grupo: ");
					String nomeDoGrupo = sc.nextLine();
					
					System.out.println(menu.imprimirGrupo(nomeDoGrupo));
				}
			}
			
			else if (opcao.equals("R")) {
				System.out.print("Matrícula: ");
				int matricula = sc.nextInt();
				sc.nextLine();
				
				System.out.println(menu.alunoQuestaoNoQuadro(matricula));
			}
			
			else if (opcao.equals("I")) {
				System.out.println(menu.imprimirAlunosQuestaoNoQuadro());
			}
			
		} while (!opcao.equals("O"));
	}
}
