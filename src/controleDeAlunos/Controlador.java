package controleDeAlunos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representacao de um controlador de alunos, que contem um HashMap de Alunos
 * e outro HashMap de Grupos, tem tambem um ArrayList de Alunos.
 * 
 * Permite cadastrar alunos, consultar alunos, criar grupos, alocar alunos em grupos,
 * imprimir alinos de deterninado grupo, cadastrar os alunos que fizeram questoes no 
 * quadro e imprimir alunos que responderam questoes no quadro.
 * 
 * @author Ezequias Rocha
 *
 */
public class Controlador {
	private HashMap<Integer, Alunos> alunos = new HashMap<>();
	private HashMap<String, Grupos> grupos = new HashMap<>();
	private ArrayList<Alunos> questoesNoQuadro = new ArrayList<>();
	private String alunosQueResponderam;
	
	/**
	 * Retorna uma string que representa se o aluno foi adicionado ao HashMap de Alunos.
	 * Se a matricula de um aluno ja estiver na lista retorna "MATRICULA JA CADASTRADA!",
	 * caso contrario retornara "CADASTRO REALIZADO!".
	 * 
	 * @param matricula interio da matricula do aluno.
	 * @param nome string do nome do aluno.
	 * @param curso string do curso do aluno.
	 * @return a representacao de uma string que indica a situacao do cadastro.
	 */
	public String cadastroDeAluno(int matricula, String nome, String curso) {
		if (alunos.containsKey(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA!\n";
		}
		
		alunos.put(matricula, new Alunos(matricula, nome, curso));
		return "CADASTRO REALIZADO!\n";
	}
	
	/**
	 * Retorna uma string com as informacoes do aluno caso ele ja tenha sido cadastrado.
	 * Caso contrario retornara uma mensagem dizendo "Aluno nao cadastrado."
	 * 
	 * @param matricula inteiro da matricula do aluno.
	 * @return a representacao da situacao de um aluno.
	 */
	public String consultarAluno(int matricula) {
		Alunos aluno = alunos.get(matricula);
		if (aluno == null) {
			return "Aluno não cadastrado.\n";			
		}
		return aluno.toString() + "\n";
	}
	
	/**
	 * Retorna "CADASTRO REALIZADO!" se o cadastro for efetuado com sucesso
	 * e "GRUPO JÁ CADASTRADO!", caso o grupo ja tenha sido cadastrado.
	 * 
	 * O nome do grupo nao deve ser nulo.
	 * 
	 * @param nomeDoGrupo string do nome do grupo.
	 * @return a situaÃ§Ã£o do cadastro do grupo.
	 */
	public String cadastrarGrupo(String nomeDoGrupo) {
		if (grupos.containsKey(nomeDoGrupo.toLowerCase())) {
			return "GRUPO JÁ CADASTRADO!\n";
		}
		grupos.put(nomeDoGrupo.toLowerCase(), new Grupos(nomeDoGrupo));
		return "CADASTRO REALIZADO!\n";
	}
	
	/**
	 * Retorna uma string que indica a situacao da alocacao do aluno em um
	 * grupo e cadastra um aluno no grupo desejado, caso ele tenha sido criado.
	 * 
	 * @param matricula inteiro da matricula do aluno.
	 * @param nomeDoGrupo string do nome do grupo.
	 * @return representacao da alocacao do aluno.
	 */
	public String alocarAluno(int matricula, String nomeDoGrupo) {
		Alunos aluno = alunos.get(matricula);
		Grupos grupo = grupos.get(nomeDoGrupo.toLowerCase());
		
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.\n";
		}
		if (!grupos.containsKey(nomeDoGrupo.toLowerCase())) {
			return "Grupo não cadastrado.\n";
		}
		
		grupo.adicionaAluno(aluno);
		return "ALUNO ALOCADO!\n";
	}
	
	/**
	 * Retorna uma string com informacoes dos alunos que foram alocados para o grupo.
	 * 
	 * @param nomeDoGrupo string do nome do grupo;
	 * @return string com informacoes dos alunos alucados no grupo.
	 */
	public String imprimirGrupo(String nomeDoGrupo) {
		if (!grupos.containsKey(nomeDoGrupo.toLowerCase())) {
			return "Grupo não cadastrado.\n";
		}
		Grupos grupo = grupos.get(nomeDoGrupo.toLowerCase());
		return grupo.imprimirAlunosAlucados();
	}
	
	/**
	 * Cadastra alunos que responderam questoes no quadro e retorna uma string
	 * que indica se o aluno foi cadastrado ou se o aluno nao foi matriculado.
	 * 
	 * @param matricula inteiro da matricula do aluno.
	 * @return string da situacao do cadastro.
	 */
	public String alunoQuestaoNoQuadro(int matricula) {
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.\n";
		}
		Alunos aluno = alunos.get(matricula);
		questoesNoQuadro.add(aluno);		
		return "ALUNO REGISTRADO!\n";
	}
	
	/**
	 * Retorna uma String com as informacoes dos alunos que responderam
	 * questoes no quadro.
	 * 
	 * @return string com os alunos que responderam questoes no quadro.
	 */
	public String imprimirAlunosQuestaoNoQuadro() {
		alunosQueResponderam = "Alunos:\n";
		for (Alunos aluno : questoesNoQuadro) {
			alunosQueResponderam += aluno.toString() + "\n";
		}
		return alunosQueResponderam;
	}
}
