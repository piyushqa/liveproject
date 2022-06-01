package utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListnerclass implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation testAnnotation, Class testClassName, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		IRetryAnalyzer retry=testAnnotation.getRetryAnalyzer();
		if(retry==null) {
		testAnnotation.setRetryAnalyzer(RetryFailedTestCases.class);
		}
		}
	}


 