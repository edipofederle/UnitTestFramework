package UnitTestFramework.UnitTestFramework;

import java.lang.reflect.Method;

public class UnitMethod {
	
	private boolean passed;
	private String name;
	private Method method;
	private String messageFail;
	
	public UnitMethod(boolean passed, String name, Method method) {
		super();
		this.passed = passed;
		this.name = name;
		this.method = method;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public String getMessageFail() {
		return messageFail;
	}
	public void setMessageFail(String messageFail) {
		this.messageFail = messageFail;
	}
	
	
}
