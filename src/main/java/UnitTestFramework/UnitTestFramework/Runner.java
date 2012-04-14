package UnitTestFramework.UnitTestFramework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Runner {
	
	private ScannerClasses scanner;
	
	
	public void runTestsInside(String[] packages) {
		Core core = Core.getInstance(); 
		try {
			scanner = new ScannerClasses(packages);
			FactoryTestsCases factoryTestsCases = new FactoryTestsCases(scanner.getKlasses());
			try {
				core.setTestsCases(factoryTestsCases.getListOfTestsCases());
				try {
					core.exec();
				} catch (IllegalArgumentException e) {
				} catch (InstantiationException e) {
				} catch (IllegalAccessException e) {
				} catch (InvocationTargetException e) {
				}
			} catch (ListOfTestCaseEmptyException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
