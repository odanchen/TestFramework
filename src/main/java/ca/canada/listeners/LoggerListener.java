package ca.canada.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoggerListener implements ITestListener, ISuiteListener {
    private final Logger logger = LoggerFactory.getLogger(LoggerListener.class);

    @Override
    public void onStart(ISuite suite) {
        logger.info("=====================================");
        logger.info("Methods to be executed:");
        Map<String, List<ITestNGMethod>> methodsByClass = suite.getAllMethods().stream().collect(Collectors.groupingBy(method -> method.getTestClass().getName()));
        methodsByClass.forEach((className, methods) -> {
            logger.info("Class: {}", className);
            methods.forEach(method -> logger.info("  └─ Method: {}", method.getMethodName()));
        });
        logger.info("Total number of methods: {}", suite.getAllMethods().size());
        logger.info("=====================================");
    }

    @Override
    public void onFinish(ISuite suite) {
        int passedTests = 0;
        int failedTests = 0;
        int skippedTests = 0;
        for (ISuiteResult suiteResult : suite.getResults().values()) {
            ITestContext context = suiteResult.getTestContext();
            passedTests += context.getPassedTests().getAllResults().size();
            failedTests += context.getFailedTests().getAllResults().size();
            skippedTests += context.getSkippedTests().getAllResults().size();
        }

        int totalTests = suite.getAllMethods().size();
        logger.info("=====================================");
        logger.info("Execution completed.");
        logger.info("   Passed: {}", passedTests);
        logger.info("   Failed: {}", failedTests);
        logger.info("  Skipped: {}", skippedTests);
        logger.info("    Total: {}", totalTests);
        logger.info("Pass rate: {}%", totalTests > 0 ? (passedTests * 100 / totalTests) : 0);
        logger.info("=====================================");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("=====================================");
        logger.info("Started test {}.{}\n", result.getTestClass().getName(), result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Passed test {}.{}", result.getTestClass().getName(), result.getName());
        logger.info("=====================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Failed test {}.{}", result.getTestClass().getName(), result.getName());
        logger.info("=====================================");
    }
}
