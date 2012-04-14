package UnitTestFramework.UnitTestFramework;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ScannerClasses {
	
	private List<Class<?>> listOfClassesAnnotedWithTest = new ArrayList<Class<?>>();
	public ScannerClasses(String[] packagesToScan) throws ClassNotFoundException, IOException{
		for(int i=0; i<packagesToScan.length;i++)
			this.getPackageContent(packagesToScan[i]);
	}
	
	public List<Class<?>> getKlasses(){
		return listOfClassesAnnotedWithTest;
	}

	private void getPackageContent(String packageName) throws IOException, ClassNotFoundException {
		packageName = packageName.replace('.', '/');
		Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName);
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			File dir = new File(url.getFile());
			for (File f : dir.listFiles()) {
				Class<?> klass = Class.forName(resolveName(packageName, f.getName()));
				if(annotedWithTest(klass,packageName, f))
					listOfClassesAnnotedWithTest.add(klass);
			}
		}
	}

	private boolean annotedWithTest(Class<?> klass,String packageName, File f) throws ClassNotFoundException {
		if (klass.isAnnotationPresent(Test.class)) 
			return true;
		return false;
	}
	
	private static String resolveName(String packageTestName, String file) {
		return packageTestName+ "." + file.substring(0,file.length() - 6);
	}
	
}