package UnitTestFramework.UnitTestFramework;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import UnitTestFramework.UnitTestFramework.Output.Report;
import UnitTestFramework.UnitTestFramework.Output.ReportFactory;

public class Core {

	public List<TestCase> testsToExecute = new ArrayList<TestCase>();
	private int executedTestsCases;

	private static Core instance;

	private Core() {
	}

	public static Core getInstance() {
		if (instance == null)
			instance = new Core();
		return instance;
	}

	public void setTestsCases(List<TestCase> listOfTestsCases)
			throws ListOfTestCaseEmptyException {
		if (listOfTestsCases.isEmpty())
			throw new ListOfTestCaseEmptyException(
					"Lista de Testes Cases vazia ou nula");

		testsToExecute = listOfTestsCases;
	}

	public void exec() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Verify verify = new Verify();
		for (TestCase testCase : testsToExecute)
			verify.setTestCase(testCase);
	}

	/**
	 * Retonra o numero de metodo de testes(anotado como @Unit) que foram executados
	 * @return
	 */
	public int getNumberOfTestsCasesExecuted() {
		return executedTestsCases;
	}
	
	public void incrementNumberOfTestsCases() {
		this.executedTestsCases++;
	}
	
	public void resetNumberOfTestsCasesExecuted(){
		this.executedTestsCases = 0;
	}

	public int numberOfTestsFailed() {
		int countNumberOfFailedTests = 0;
		for (TestCase testCase : testsToExecute) {
			if(!testCase.isPassed())
				countNumberOfFailedTests++;
		}
		return countNumberOfFailedTests;
	}
	
	/**
	 * Print final results
	 */
	public void finalResults(String typeOfReport) {
		Report a = ReportFactory.getReport(typeOfReport, testsToExecute);
		a.makeReport();
	}

}
