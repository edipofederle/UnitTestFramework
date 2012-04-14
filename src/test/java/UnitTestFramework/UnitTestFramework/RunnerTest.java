package UnitTestFramework.UnitTestFramework;

public class RunnerTest {
	
	public void oQueDeveFazer(){
		Runner runner = new Runner();
		String packages[] = {"foo1", "bar2"};
		runner.runTestsInside(packages);
	}
}
