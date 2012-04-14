package bar2;

import UnitTestFramework.UnitTestFramework.Assert;
import UnitTestFramework.UnitTestFramework.Test;
import UnitTestFramework.UnitTestFramework.Unit;

@Test
public class HelloWorld {
	
	@Unit
	public void helloWorl(){
		System.out.println("Testando isTrue()");
		Assert.isTrue("Falhou", false);
	}
}
