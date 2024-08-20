package demoqa.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {
  Logger logger = LoggerFactory.getLogger(MyListener.class);

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    WebDriverListener.super.beforeFindElement(driver, locator);
    logger.info("Before find Element ==>> " + locator);
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    WebDriverListener.super.afterFindElement(driver, locator, result);
    logger.info("After find Element ==>> " + locator);
  }

  @Override
  public void beforeFindElements(WebDriver driver, By locator) {
    WebDriverListener.super.beforeFindElements(driver, locator);
    logger.info("Before find Elements ==>> " + locator);
  }

  @Override
  public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
    WebDriverListener.super.afterFindElements(driver, locator, result);
    logger.info("After find Elements ==>> " + locator);
    logger.info("After find Elements ==>> " + result.size());
  }

  @Override
  public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
    WebDriverListener.super.onError(target, method, args, e);
    logger.error("Что-то пошло не так!!");
    logger.error("***************************************************");
    logger.error("Method ==>> " + method.getName());
    logger.error("***************************************************");
    logger.error("Object target ==>> " + target.toString());
    logger.error("***************************************************");
    logger.error("Target exception ==>> " + e.getTargetException());
    logger.error("***************************************************");
    int random = new Random().nextInt(1000) + 1000;
    String path = "src/screenshots/screen_" + random + ".png";
    logger.error("Screenshot path is: " + path);
    WebDriver driver = (ChromeDriver) target;
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File tmp = screenshot.getScreenshotAs(OutputType.FILE);
    try {
      Files.copy(tmp, new File(path));
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void beforeGet(WebDriver driver, String url) {
    WebDriverListener.super.beforeGet(driver, url);
    logger.info("Before get url ==>> " + url);
  }

  @Override
  public void afterGet(WebDriver driver, String url) {
    WebDriverListener.super.afterGet(driver, url);
    logger.info("After get url ==>> " + url);
  }
}
