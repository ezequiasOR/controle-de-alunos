package controleDeAlunos;

/**
 * Representacao de um aluno. Todo aluno precisa ter uma matricula, um nome
 * o curso. A identificacao do aluno e feita por sua matricula.
 * 
 * @author Ezequias Rocha
 */
public class Alunos {
	private int matricula;
	private String nome;
	private String curso;
	
	/**
	 * Controi um aluno a partir da sua matricula, do seu nome e de seu curso.
	 * Os Atributos nao devem ser nulos. Se alguma das variaveis forem nula
	 * sera lancada uma excecao.
	 * 
	 * @param matricula inteiro da matricula do aluno.
	 * @param nome string do nome do aluno.
	 * @param curso string do curso do aluno.
	 */
	public Alunos(int matricula, String nome, String curso) {
		if (nome == null || curso == null) {
			throw new NullPointerException();
		}
		else if (nome.equals("".trim()) || curso.equals("".trim())) {
			throw new NullPointerException();	
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	public int getMatricula () {
		return this.matricula;
	}
	
	/**
	* Retorna a String que representa o aluno. A representacao segue o
	* formato: Aluno: (matricula do aluno) - (nome do aluno) - (curso do aluno).
	*
	* @return a representacao em String de um aluno.
	*/
	@Override
	public String toString() {
		return "Aluno: " + matricula + " - " + nome + " - " + curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alunos other = (Alunos) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
}
