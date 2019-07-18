package commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.ITestResult;

/* 
 * TestNG requires a call to Reporter.log to insert logging statements into the report
 * */
public class VerificationFailures extends HashMap<ITestResult, List<Throwable>>  {
	private static final long serialVersionUID = 1L;
	private static VerificationFailures failures;
	
	private VerificationFailures() {
		super();
	}
	public static VerificationFailures getFailures() {
		if (failures == null) {
			failures = new VerificationFailures();
		}
		return failures;
	}
	public List<Throwable> getFailuresForTest(ITestResult result){
		List<Throwable> exceptions = get(result);
		// if (exception == null) is true (No happen exception) => return ArrayList
		// if (exception == null) is false (Happen exception) => return exception
		return exceptions == null ? new ArrayList<Throwable>() : exceptions;
	}
	
	public void addFailureForTest(ITestResult result, Throwable throwable) {
		List<Throwable> exceptions = getFailuresForTest(result);
		exceptions.add(throwable);
		put(result, exceptions);
	}

}
