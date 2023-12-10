package com.selenium.testnglisteners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
				annotation.setRetryAnalyzer(Retry.class);
	}

}


//we use Annotation transformer to implement retry analyzer for all test cases globally