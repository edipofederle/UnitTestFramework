package exemplos;

import UnitTestFramework.UnitTestFramework.Assert;
import UnitTestFramework.UnitTestFramework.Test;
import UnitTestFramework.UnitTestFramework.Unit;

@Test
public class MathIdiot {
	
	@Unit
	public void testException(){
		Assert.isTrue("Show me if i fail", true);
	}
	
	@Unit
	public void testSemNome(){
		Assert.isTrue("Message", true);
	}
	
	@Unit
	public void meuMetodo(){
		Assert.isTrue("Fail Message", false);
	}


}
