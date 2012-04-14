package UnitTestFramework.UnitTestFramework;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runner runner = new Runner();
		String pacotes[] = {"bar2", "foo1"};
		runner.runTestsInside(pacotes);
		System.out.println("Total of Tests: " + Core.getInstance().getNumberOfTestsCasesExecuted());
	}

}
