package UnitTestFramework.UnitTestFramework;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class FactoryTestsCasesTest extends TestHelper {
	
	@Test
	public void shouldCreateAListOfTestsCases() throws ClassNotFoundException, IOException{
		List<TestCase> listaOfTestsCases = getAListOfTests();
		Assert.assertNotNull(listaOfTestsCases );
	}
	
	@Test
	public void shouldContainOnlyMethodsAnnotedWithUnit() throws ClassNotFoundException, IOException{
		List<TestCase> listaOfTestsCases = getAListOfTests();
		Assert.assertEquals(2, listaOfTestsCases.size());
		int totalMethodsToTest = 0;
		for (TestCase testCase : listaOfTestsCases){
			for (UnitMethod method : testCase.getListMethodsAnnotedWithUnit()) {
				if(method.getName().equals("semTest"))
					Assert.fail();
			}
			totalMethodsToTest+= testCase.getListMethodsAnnotedWithUnit().size();
		}
		Assert.assertEquals(2, totalMethodsToTest);
		
	}
	
	@Test
	public void shouldContainCorrectNamesForKlasses() throws ClassNotFoundException, IOException{
		List<TestCase> listaOfTestsCases = getAListOfTests();

		Assert.assertEquals("digaAlo", listaOfTestsCases.get(0).getListMethodsAnnotedWithUnit().get(0).getName());
		Assert.assertEquals("foo1", listaOfTestsCases.get(0).getPackageName());
		
		Assert.assertEquals("helloWorl", listaOfTestsCases.get(1).getListMethodsAnnotedWithUnit().get(0).getName());
		Assert.assertEquals("bar2", listaOfTestsCases.get(1).getPackageName());
	}



	
}