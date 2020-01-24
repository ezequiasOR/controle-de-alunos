package controleDeAlunos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControladorTest {
	private Controlador controlador;
	private String imprimirGrupo;
	private String imprimiAlunos;

	@BeforeEach
	public void ControladorTestes() {
		controlador = new Controlador();
		controlador.cadastroDeAluno(456789123, "Zé", "Psicologia");
		controlador.cadastroDeAluno(852963741, "Edna", "Pedagogia");
		controlador.cadastroDeAluno(963852741, "Carla", "Computação");
		controlador.cadastrarGrupo("estudar calculo");
		controlador.alocarAluno(852963741, "estudar calculo");
		controlador.alocarAluno(963852741, "estudar calculo");
		imprimirGrupo = "\nAlunos do grupo estudar calculo:\n" + "Aluno: 852963741 - Edna - Pedagogia\n"
					+ "Aluno: 963852741 - Carla - Computação\n";
	}
	
	@Test
	void testCadastroDeAluno() {
		assertEquals("CADASTRO REALIZADO!\n", controlador.cadastroDeAluno(123456789, "Ezequias", "Computação"));
		assertEquals("MATRÍCULA JÁ CADASTRADA!\n", controlador.cadastroDeAluno(123456789, "Matheus Gaudencio", "Computação"));
		assertEquals("CADASTRO REALIZADO!\n", controlador.cadastroDeAluno(987654321, "Sivirino da Pamonha", "Padaria"));
	}

	@Test
	void testConsultarAluno() {
		assertEquals("Aluno não cadastrado.\n", controlador.consultarAluno(123456789));
		assertEquals("Aluno: 456789123 - Zé - Psicologia\n", controlador.consultarAluno(456789123));
	}

	@Test
	void testCadastrarGrupo() {
		assertEquals("CADASTRO REALIZADO!\n", controlador.cadastrarGrupo("estudo"));
		assertEquals("CADASTRO REALIZADO!\n", controlador.cadastrarGrupo("futsal"));
		assertEquals("GRUPO JÁ CADASTRADO!\n", controlador.cadastrarGrupo("estudo"));
		assertEquals("GRUPO JÁ CADASTRADO!\n", controlador.cadastrarGrupo("futsal"));
	}

	@Test
	void testAlocarAluno() {
		assertEquals("ALUNO ALOCADO!\n", controlador.alocarAluno(456789123, "estudar calculo"));
		assertEquals("Aluno não cadastrado.\n", controlador.alocarAluno(741852963, "estudar calculo"));
		assertEquals("Grupo não cadastrado.\n", controlador.alocarAluno(456789123, "almoço"));
		assertEquals("ALUNO ALOCADO!\n", controlador.alocarAluno(963852741, "estudar calculo"));
	}
	
	@Test
	void testImprimirGrupo() {
		assertEquals(imprimirGrupo, controlador.imprimirGrupo("estudar calculo"));
		assertEquals("Grupo não cadastrado.\n", controlador.imprimirGrupo("almoço"));
	}

	@Test
	void testAlunoQuestaoNoQuadro() {
		assertEquals("ALUNO REGISTRADO!\n", controlador.alunoQuestaoNoQuadro(963852741));
		assertEquals("ALUNO REGISTRADO!\n", controlador.alunoQuestaoNoQuadro(852963741));
		assertEquals("Aluno não cadastrado.\n", controlador.alunoQuestaoNoQuadro(587321849));
		assertEquals("Aluno não cadastrado.\n", controlador.alunoQuestaoNoQuadro(451546463));
	}

	@Test
	void testImprimirAlunosQuestaoNoQuadro() {
		assertEquals("Alunos:\n", controlador.imprimirAlunosQuestaoNoQuadro());
		controlador.alunoQuestaoNoQuadro(963852741);
		controlador.alunoQuestaoNoQuadro(852963741);
		imprimiAlunos = "Alunos:\n" + "Aluno: 963852741 - Carla - Computação\n"
					+ "Aluno: 852963741 - Edna - Pedagogia\n";
		assertEquals(imprimiAlunos, controlador.imprimirAlunosQuestaoNoQuadro());
	}
}
