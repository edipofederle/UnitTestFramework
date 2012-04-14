package foo1;

import UnitTestFramework.UnitTestFramework.Assert;
import UnitTestFramework.UnitTestFramework.Test;
import UnitTestFramework.UnitTestFramework.Unit;

@Test
public class MinhaClasse {
	
	@Unit
	public void digaAlo(){
		System.out.println("Diga Ola");
		Assert.isTrue("Isnt true", false);
	}
	
	public void semTest(){
		//Nao deve ser executado
	}
	
}
