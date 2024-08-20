package demoqa.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public void setUp() {
    logger.info("****************** TESTING IN PROGRESS ******************");
    app.startTest();
  }

  @BeforeMethod
  public void startTest(Method method, Object[] parameters) {
    if (parameters != null && parameters.length > 0) {
      logger.info("Test is started: [" + method.getName() + "], with data: " + Arrays.asList(parameters));
    } else {
      logger.info("Test is started: [" + method.getName() + "] with no data");
    }
  }

  @AfterMethod
  public void endTest(Method method, ITestResult result) {
    if (result.isSuccess()) {
      logger.info("Test is PASSED: [" + method.getName() + "]");
    } else {
      logger.error("Test is FAILED: [" + method.getName() + "]");
    }
    logger.info("Test is ended: [" + method.getName() + "]");
  }

  //@AfterMethod(enabled = true)
  @AfterSuite(enabled = false)
  public void tearDown() {
    app.stopTest();
    logger.info("****************** ALL TEST END ******************");
  }

}
