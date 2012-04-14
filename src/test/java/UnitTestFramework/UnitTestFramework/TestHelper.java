package UnitTestFramework.UnitTestFramework;

import java.io.IOException;
import java.util.List;

public class TestHelper {

	public List<TestCase> getAListOfTests() throws ClassNotFoundException,	IOException {
		List<Class<?>> klasses = whenScanTwoPackages();
		FactoryTestsCases factoryTestsCases = new FactoryTestsCases(klasses);
		List<TestCase> listaOfTestsCases = factoryTestsCases
				.getListOfTestsCases();
		return listaOfTestsCases;
	}

	private List<Class<?>> whenScanTwoPackages() throws ClassNotFoundException, IOException {
		String[] packagesToScan = {"foo1", "bar2"};
		ScannerClasses scanner = new ScannerClasses(packagesToScan);
		List<Class<?>> a = scanner.getKlasses();
		return a;
	}
	
	public List<TestCase> getAListOfTestsFromExemplosTests() throws ClassNotFoundException, IOException{
		List<Class<?>> klasses = whenScanPackageExemplosTests();
		FactoryTestsCases factoryTestsCases = new FactoryTestsCases(klasses);
		List<TestCase> listaOfTestsCases = factoryTestsCases.getListOfTestsCases();
		return listaOfTestsCases;
	}
	
	private List<Class<?>> whenScanPackageExemplosTests() throws ClassNotFoundException, IOException{
		String[] packagesToScan = {"exemplos"};
		ScannerClasses scanner = new ScannerClasses(packagesToScan);
		List<Class<?>> a = scanner.getKlasses();
		return a;
	}
}
