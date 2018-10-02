package engsoftware;

import static org.junit.Assert.*;

import org.junit.Test;

import customexceptions.MatriculaInvalidaException;
import customexceptions.NomeInvalidoException;

public class TesteMain {
	
	@Test
	public void NomeTeste1() {
		try {
			Politico p1 = new Politico("Matheus", "Talacio", Cargos.DEP_ESTADUAL, 1234);
			assertEquals("Matheus", p1.getNome());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void NomeTeste2() {
		try {
			Politico p1 = new Politico("Mat", "Talacio", Cargos.DEP_ESTADUAL, 1234);
			fail("Exceção não jogada!");
		} catch (NomeInvalidoException e) {
			// Ok
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void InscricaoTeste1() {
		try {
			Politico p1 = new Politico("Matheus", "Talacio", Cargos.DEP_ESTADUAL, -34);
			fail("Exceção não jogada!");
		}
		catch (MatriculaInvalidaException e) {
			// Ok
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
