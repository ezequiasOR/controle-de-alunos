package controleDeAlunos;

import java.util.ArrayList;

/**
 * Representacao de um grupo. Todo grupo tem um nome e uma ArrayList
 * com os alunos que fazem parte do grupo
 * 
 * @author Ezequias Rocha
 */
public class Grupos {
	private String nomeDoGrupo;
	private String saida;
	private ArrayList<Alunos> alunosDoGrupo = new ArrayList<>();
	
	/**
	 * Controi um grupo a partir do nome do grupo.
	 * O atributo nomeDoGrupo nao deve ser nulo.
	 * Se a variavel for nula sera lacada uma excecao.
	 * 
	 * @param nomeDoGrupo string do nome do grupo
	 */
	public Grupos(String nomeDoGrupo) {
		if (nomeDoGrupo == null) {
			throw new NullPointerException();
		}
		else if (nomeDoGrupo.equals("".trim())) {
			throw new NullPointerException();	
		}
		
		this.nomeDoGrupo = nomeDoGrupo;
		alunosDoGrupo = new ArrayList<>();
	}
	
	public String getNomeDoGrupo() {
		return nomeDoGrupo;
	}
	
	/**
	 * Adiciona Aluno a lista de alunos que fazem parte do grupo.
	 * 
	 * @param aluno informacoes do aluno.
	 */
	public void adicionaAluno(Alunos aluno) {
		if (!alunosDoGrupo.contains(aluno)) {			
			alunosDoGrupo.add(aluno);
		}
	}
	
	/**
	* Retorna a String que representa a lista de alunos alocados no grupo.
	*
	* @return a lista de alunos alocados no grupo.
	*/
	public String imprimirAlunosAlucados() {
		saida = "\nAlunos do grupo " + this.nomeDoGrupo + ":\n";
		for (Alunos aluno : alunosDoGrupo) {
			saida += aluno.toString() + "\n";
		}
		return saida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDoGrupo == null) ? 0 : nomeDoGrupo.hashCode());
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
		Grupos other = (Grupos) obj;
		if (nomeDoGrupo == null) {
			if (other.nomeDoGrupo != null)
				return false;
		} else if (!nomeDoGrupo.equals(other.nomeDoGrupo))
			return false;
		return true;
	}
}
