package FileUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	int count = 0;
	int limitCount = 5;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limitCount) {
		count++;
			return true;
		}
		return false;
	}

	
	
}
