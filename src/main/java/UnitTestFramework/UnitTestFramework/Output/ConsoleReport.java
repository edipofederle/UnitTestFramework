package UnitTestFramework.UnitTestFramework.Output;

import UnitTestFramework.UnitTestFramework.TestCase;
import UnitTestFramework.UnitTestFramework.UnitMethod;



/**
 * 
 * @author Edipo Federle
 * @author Robson Paulo Kraemer (rpkraemer@gmail.com) 
 *
 *
 */
class ConsoleReport extends ReportBase {

	private String report;
	
	public ConsoleReport(ExecutionInformation executionInformation) {
		this.executionInformation = executionInformation;
		this.report = "";
	}
	
	@Override
	public boolean generateHeader() {
		report += "*** RELATORIO MODE CONSOLE ***\n\n";
		return true;
	}

	@Override
	public boolean generateBody() {
		for (TestCase item : executionInformation.getTestsInfo()) {
			report+=item.getKlassName()+"\n";
			for (UnitMethod methodUnit : item.getListMethodsAnnotedWithUnit()) {
				report+=("\t*"+ methodUnit.getName() + " - " + methodUnit.isPassed() + showMessageFailTest(methodUnit.getMessageFail()) + "\n");
			}
			report+=("\n");
		}
		return true;
	}

	@Override
	public boolean generateFooter() {
		return true;
	}
	
	@Override
	public void makeReport() {
		super.makeReport();
		System.out.println(this.report);
	}
	
	private String showMessageFailTest(String message){
		return message != null ? "(" +message +")" : "";
	}

}
