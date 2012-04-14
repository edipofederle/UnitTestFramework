package UnitTestFramework.UnitTestFramework;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class Verify {
	
	private TestCase testCase;
	private static Core core = Core.getInstance();
	public List<TestCase> listResults = new ArrayList<TestCase>(); 
	public static String failMessageTemp = null;
	
	public void setTestCase(TestCase testCase) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException{
		this.testCase = testCase;
		executeTestCase();
	}

	private void executeTestCase() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		Class<?> klass = null;
		Object obj = null;
		for (UnitMethod method : testCase.getListMethodsAnnotedWithUnit()) {
			klass = Class.forName(testCase.getKlassName());
			obj = klass.newInstance();
			try{
				method.getMethod().invoke(obj);
			}catch (InvocationTargetException e) {
				method.setPassed(false);
				if(failMessageTemp != null)
					method.setMessageFail(failMessageTemp);
			}
			core.incrementNumberOfTestsCases();
		}
		  			
	}

}