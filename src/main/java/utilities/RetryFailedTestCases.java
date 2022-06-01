package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer{
private int retrycnt=0;
private int maxRetrycnt=2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		try {
		if(retrycnt<maxRetrycnt) {
			System.out.println("Retrying"+result.getName()+"again and count is"+(retrycnt+1));
			retrycnt++;
			return true;
		}

		}catch(Exception e) {if(++retrycnt==maxRetrycnt)
			throw e;
		}
		return false;
	}

}
