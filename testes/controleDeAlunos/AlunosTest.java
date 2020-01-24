package controleDeAlunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunosTest {
	private Alunos aluno;
	
	@BeforeEach
	public void criaAluno() {
		aluno = new Alunos(123456789, "Joquim", "Medicina");
	}
	
	@Test
	void testAlunosNomeNulo() {
		try {
			Alunos alunoInvalido = new Alunos(123456789, null, "CC");
			fail("Era esperado exceção ao passar código nulo");			
		} catch (NullPointerException npe) {
			
		} catch (IllegalArgumentException iae) {
		
		}
	}
	
	@Test
	void testAlunosCursoNulo() {
		try {
			Alunos alunoInvalido = new Alunos(123456789, "Zé", null);
			fail("Era esperado exceção ao passar código nulo");			
		} catch (NullPointerException npe) {

		} catch (IllegalArgumentException iae) {
			
		}
	}

	@Test
	void testAlunosNomeVazio() {
		try {
			Alunos alunoInvalido = new Alunos(123456789, "", "CC");
			fail("Era esperado exceção ao passar código nulo");			
		} catch (NullPointerException npe) {

		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testAlunosCursoVazio() {
		try {
			Alunos alunoInvalido = new Alunos(123456789, "ZÃ©", "");
			fail("Era esperado exceção ao passar código nulo");			
		} catch (NullPointerException npe) {

		} catch (IllegalArgumentException iae) {
			
		}
	}

	@Test
	void testGetMatricula() {
		assertEquals(123456789, aluno.getMatricula());
	}

	@Test
	void testToString() {
		assertEquals("Aluno: 123456789 - Joquim - Medicina", aluno.toString());
	}
}
