package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {
  public LinksPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "a")
  List<WebElement> allLinks;

  public LinksPage checkAllURL() {
    // Инициализирует пустую строковую переменную с именем URL.
    // Эта переменная предназначена для хранения текста URL-адреса каждой ссылки, найденной на веб-странице.
    String url = "";

    System.out.println("Total links on the web page: " + allLinks.size());

    Iterator<WebElement> iterator = allLinks.iterator();

    while (iterator.hasNext()) {
      url = iterator.next().getText();
      System.out.println(url);
    }
    return this;
  }

  public LinksPage checkBrokenLinks() {
    for (WebElement link : allLinks) {
      String linkText = link.getText();
      String linkURL = link.getAttribute("href");
      if (linkURL != null) {
        System.out.println("Link text: [" + linkText + "], link URL: [" + linkURL + "]");
        verifyLink(linkURL);
      } else {
        System.err.println("Link text: [" + linkText + "], link URL: [null]");
      }
    }
    return this;
  }
}
