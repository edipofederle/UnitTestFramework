package UnitTestFramework.UnitTestFramework.Output;

import java.util.ArrayList;
import java.util.List;

import UnitTestFramework.UnitTestFramework.TestCase;

/**
 * 
 * @author Edipo Federle
 * @author Robson Paulo Kraemer (rpkraemer@gmail.com) 
 *
 *
 */
public class ExecutionInformation {
	
	public static int numberOfTests = 0;
	public static int numberOfFailedTests = 0;
	
	private static List<TestCase> listTests = new ArrayList<TestCase>();
	
	public ExecutionInformation(List<TestCase> listTests ) {
		ExecutionInformation.listTests = listTests;
	}
	
	public List<TestCase> getTestsInfo(){
		return ExecutionInformation.listTests;
	}
	
	public int numberOfAssertions(){
		return ExecutionInformation.listTests.size();
	}
	
	/*
	public static int numberOfFailedTests(){
		ArrayList<TestCase> groupOfCommonAsserts = new ArrayList<TestCase>();
		boolean fail = false;
		for(int i=0; i < numberOfTests; i++){
			String nome = listTests.get(i).getMethodName() + listTests.get(i).getKlassName();
			for (TestCase testCase : listTests) {
				String target = testCase.getMethodName() + testCase.getKlassName();
				if(target.equals(nome))
					groupOfCommonAsserts.add(testCase);
			}
			for (TestCase t : groupOfCommonAsserts) {
				if(!t.isPass())
					fail = true;
			}
			if(fail)
				numberOfFailedTests++;
			groupOfCommonAsserts.clear();
			fail = false;
		}
		return numberOfFailedTests;
	}*/
	
	public int numberOfPassedTests(){
		return numberOfTests - numberOfFailedTests;
	}

}
