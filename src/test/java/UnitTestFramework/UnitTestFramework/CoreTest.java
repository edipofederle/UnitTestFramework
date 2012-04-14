package UnitTestFramework.UnitTestFramework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class CoreTest  extends TestHelper{

	private Core core;
	
	@Before
	public void setUp(){
		core = Core.getInstance();
		core.resetNumberOfTestsCasesExecuted();
	}
	
	@Test
	public void shouldBeASingletonClass(){
		Core core = Core.getInstance();
		Assert.assertNotNull(core);
		Core core1 = Core.getInstance();
		Assert.assertSame(core, core1);
	}
	
	@Test(expected=ListOfTestCaseEmptyException.class)
	public void shouldRiseExceptionWhenRecieveAListOfTestCaseEmpty() throws ListOfTestCaseEmptyException{
		List<TestCase> a = new ArrayList<TestCase>();
		core.setTestsCases(a);
	}
	
	@Test
	public void shouldRecieveAListOfTestCases() throws ClassNotFoundException, IOException, ListOfTestCaseEmptyException{
		List<TestCase> listTestsCases = getAListOfTests();
		core.setTestsCases(listTestsCases);
		List<TestCase> a = core.testsToExecute;
		Assert.assertNotNull(a);
		Assert.assertEquals(2, a.size());
	}
	
	@Test
	public void shouldInvokeTwoTest() throws IllegalArgumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, ListOfTestCaseEmptyException, IOException{
		List<TestCase> listTestsCases = getAListOfTests();
		core.setTestsCases(listTestsCases);
		core.exec();
		Assert.assertEquals(2, core.getNumberOfTestsCasesExecuted());
		for (TestCase testCase : listTestsCases) {
			Assert.assertFalse(testCase.isPassed()); // Ambos testes falharam.
		}
	}
	
	@Test
	public void shouldFailedTestCase() throws ClassNotFoundException, IOException, ListOfTestCaseEmptyException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		List<TestCase> listTestsCases = getAListOfTestsFromExemplosTests();
		core.setTestsCases(listTestsCases);
		core.exec();
		Assert.assertEquals(4, core.getNumberOfTestsCasesExecuted());
		Assert.assertFalse(listTestsCases.get(0).getListMethodsAnnotedWithUnit().get(0).isPassed());
		Assert.assertTrue(listTestsCases.get(1).getListMethodsAnnotedWithUnit().get(0).isPassed());
		Assert.assertEquals(2, core.numberOfTestsFailed());
	}
}
