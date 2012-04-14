package UnitTestFramework.UnitTestFramework;

import java.util.List;

public class TestCase {
	
	private String packageName;
	private String klassName;
	private List<UnitMethod> listMethodsAnnotedWithUnit;
	private boolean passed = false;
	
	public TestCase(String packageName, String klassName, List<UnitMethod> listMethodsAnnotedWithUnit) {
		super();
		this.packageName = packageName;
		this.klassName = klassName;
		this.listMethodsAnnotedWithUnit = listMethodsAnnotedWithUnit;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getKlassName() {
		return klassName;
	}
	public void setKlassName(String klassName) {
		this.klassName = klassName;
	}
	public List<UnitMethod> getListMethodsAnnotedWithUnit() {
		return listMethodsAnnotedWithUnit;
	}
	public void setListMethodsAnnotedWithUnit(
			List<UnitMethod> listMethodsAnnotedWithUnit) {
		this.listMethodsAnnotedWithUnit = listMethodsAnnotedWithUnit;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
}
