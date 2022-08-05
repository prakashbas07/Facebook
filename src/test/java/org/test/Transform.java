package org.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Transform implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		System.out.println(annotation);
		System.out.println(testClass);
		System.out.println(testConstructor);
		System.out.println(testMethod);
		annotation.setRetryAnalyzer(RetryAnalyzerTest.class);
		
	}

}
