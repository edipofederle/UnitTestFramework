package UnitTestFramework.UnitTestFramework;

public class Assert {
	
	public static void isTrue(String messageifItFail, boolean test){
		if(!test)
			failTest(messageifItFail);
	}

	private static void failTest(String messageifItFail) {
		if (messageifItFail == null)
			throw new AssertionError();
		Verify.failMessageTemp = messageifItFail; // Artificio Tecnologico Temporario :( FIXME
		throw new AssertionError(messageifItFail);
	}
	
}
