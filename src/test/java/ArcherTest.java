import static org.junit.Assert.*;

import org.junit.Test;

import hu.unideb.inf.beadando.Archer;

public class ArcherTest {

	Archer archer = new Archer();
	@Test
	public void test() {
		archer.MoveTo(50, 20);
		assertEquals(50.0, archer.getPositionX(), 0);
		assertEquals(20.0, archer.getPositionY(), 0);
	}

}