package UnitTestFramework.UnitTestFramework.Output;

import java.util.List;

import UnitTestFramework.UnitTestFramework.TestCase;

/**
 * 
 * @author Edipo Federle
 * @author Robson Paulo Kraemer (rpkraemer@gmail.com) 
 *
 *
 */
public class ReportFactory {

	public static Report getReport(String type, List<TestCase> listTests) {
		ExecutionInformation testsInfos = new ExecutionInformation(listTests);
		if(type == null){
			throw new IllegalArgumentException("Precisa especificar um tipo de output");
		}else{
			if(type.equals("CONSOLE")){
				return new ConsoleReport(testsInfos);
			}
		}
		return null;
		
	}
}
