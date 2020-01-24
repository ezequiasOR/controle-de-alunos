package controleDeAlunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GruposTest {
	private Grupos grupo;
	private String imprimirGrupo;
	
	@BeforeEach
	private void GruposTestes() {
		grupo = new Grupos("estudo");
	}
	
	@Test
	void testGruposNomeNulo() {
		try {
			Grupos grupoInvalido = new Grupos(null);
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {

		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testGruposNomeVazio() {
		try {
			Grupos grupoInvalido = new Grupos("");
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {

		} catch (IllegalArgumentException iae) {
			
		}
	}

	@Test
	void testGetNomeDoGrupo() {
		assertEquals("estudo", grupo.getNomeDoGrupo());
	}
}
