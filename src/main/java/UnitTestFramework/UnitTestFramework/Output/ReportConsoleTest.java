package UnitTestFramework.UnitTestFramework.Output;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import UnitTestFramework.UnitTestFramework.Core;
import UnitTestFramework.UnitTestFramework.ListOfTestCaseEmptyException;
import UnitTestFramework.UnitTestFramework.TestCase;
import UnitTestFramework.UnitTestFramework.TestHelper;


/**
 * 
 * @author Edipo Federle
 * @author Robson Paulo Kraemer (rpkraemer@gmail.com) 
 *
 *
 */
public class ReportConsoleTest extends TestHelper {
	
	private static ArrayList<TestCase> listTests = new ArrayList<TestCase>();
	
	@Before
	public void setUp(){
		listTests.clear();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldRiseExp(){
		ReportFactory.getReport(null,null);
	}
	
	@Test(expected=ReportGenerationException.class)
	public void shoudlRiseExpSemDatSource(){
		Report a = ReportFactory.getReport("CONSOLE", null);
		a.makeReport();
	}
	
	@Test
	public void testReportConsole() throws ListOfTestCaseEmptyException, IllegalArgumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException{
		Core core = Core.getInstance();
		List<TestCase> listTestsCases = getAListOfTestsFromExemplosTests();
		core.setTestsCases(listTestsCases);
		core.exec();
		Report a = ReportFactory.getReport("CONSOLE", core.testsToExecute);
		a.makeReport();
	}
}
