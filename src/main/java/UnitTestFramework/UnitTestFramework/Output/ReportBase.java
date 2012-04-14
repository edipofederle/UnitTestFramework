package UnitTestFramework.UnitTestFramework.Output;

/**
 * 
 * @author Edipo Federle
 * @author Robson Paulo Kraemer (rpkraemer@gmail.com) 
 *
 *
 */
abstract class ReportBase implements Report {
	
	protected ExecutionInformation executionInformation;
	
	public abstract boolean generateHeader();
	public abstract boolean generateBody();
	public abstract boolean generateFooter();
	
	public void makeReport() {
        if (executionInformation == null || executionInformation.getTestsInfo() == null)
                throw new ReportGenerationException("It was not specified a data source for: executionInformation");
        
        if (!(generateHeader() &&
                  generateBody() &&
                  generateFooter()))
                throw new ReportGenerationException("Could not generate the report");
	}
	
	public ExecutionInformation getExecutionInformation() {
		return executionInformation;
	}
	public void setExecutionInformation(ExecutionInformation executionInformation) {
		this.executionInformation = executionInformation;
	}
}
