package exemplos;

import UnitTestFramework.UnitTestFramework.Assert;
import UnitTestFramework.UnitTestFramework.Test;
import UnitTestFramework.UnitTestFramework.Unit;

@Test
public class Math {
	
	@Unit
	public void maiorQueDez(){
		Assert.isTrue("Nao eh maior que dez", maiorQueDez(4));
	}

	private boolean maiorQueDez(int i) {
		if(i > 10)
			return true;
		return false;
	}

}
