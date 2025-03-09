package ca.canada.listeners;

import ca.canada.driver.DriverProvider;
import ca.canada.utils.ScreenshotTaker;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class ScreenshotListener implements IInvokedMethodListener {
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            ScreenshotTaker.takeScreenshot(method.getTestMethod().getMethodName(), DriverProvider.getDriver());
        }
    }
}
