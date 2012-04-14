package UnitTestFramework.UnitTestFramework;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class ScannerClassesTest {
	
	@Test
	public void shouldLoadTwoClasses() throws ClassNotFoundException, IOException{
		List<Class<?>> a = whenScanTwoPackages();
		Assert.assertNotNull(a);
		Assert.assertEquals(2,a.size());
	}
	
	@Test
	public void shouldHaveCorrectNameForClasses() throws ClassNotFoundException, IOException{
		List<Class<?>> a = whenScanTwoPackages();
		Assert.assertEquals(a.get(0).getName(), "foo1.MinhaClasse");
		Assert.assertEquals(a.get(1).getName(), "bar2.HelloWorld");
	}
	
	private List<Class<?>> whenScanTwoPackages() throws ClassNotFoundException, IOException {
		String[] packagesToScan = {"foo1", "bar2"};
		ScannerClasses scanner = new ScannerClasses(packagesToScan);
		List<Class<?>> a = scanner.getKlasses();
		return a;
	}

}
