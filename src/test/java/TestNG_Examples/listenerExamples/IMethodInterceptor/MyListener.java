package TestNG_Examples.listenerExamples.IMethodInterceptor;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MyListener implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methodsInstance, ITestContext testContext) {
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();
        for (IMethodInstance method : methodsInstance) {
            Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
            if (testMethod.priority() == 1) {
                result.add(method);
            }
        }
        return result;
    }
}
