package UnitTestFramework.UnitTestFramework;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FactoryTestsCases {

	private List<Class<?>> klasses;

	public FactoryTestsCases(List<Class<?>> klasses) {
		this.klasses = klasses;
	}

	public List<TestCase> getListOfTestsCases() {
		List<TestCase> listTestsCases = new ArrayList<TestCase>();
		
		for (Class<?> klass : klasses) {
			List<UnitMethod> listMethodsAnnotedWithUnit = new ArrayList<UnitMethod>();
			for (Method m : klass.getMethods()) {
				if (m.isAnnotationPresent(Unit.class)){
					UnitMethod unit = new UnitMethod(true, m.getName(), m);
					listMethodsAnnotedWithUnit.add(unit);
				}
			}
			listTestsCases.add(new TestCase(klass.getPackage().getName(), klass.getName(), listMethodsAnnotedWithUnit));
		}
		return listTestsCases;
	}
}
