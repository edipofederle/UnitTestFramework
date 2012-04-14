package UnitTestFramework.UnitTestFramework;

import org.junit.Test;




public class AssertionTest {

	@Test(expected=AssertionError.class)
	public void shouldPassWhenIsFalse(){
		Assert.isTrue("Teste Falhou OMG", false);
	}
	
	@Test
	public void shouldPassWhenIsTrue(){
		Assert.isTrue("Mostra se Teste falha", true);
	}
	
	
}



