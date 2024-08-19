package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenLinksImagesPage extends BasePage {
  public BrokenLinksImagesPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "img")
  List<WebElement> allImages;

  public BrokenLinksImagesPage checkBrokenImages() {
    try {
      System.out.println("Total images on the Page is: [" + allImages.size() + "]");
      for (WebElement image : allImages) {
        String imageURL = image.getAttribute("src");
        if (imageURL != null) {
          verifyLink(imageURL);
        }
        boolean imageDisplay = (Boolean) js.executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0)", image);
        if (imageDisplay) {
          System.out.println("Image src is: [" + imageURL + "] Image is displayed!");
        } else {
          System.err.println("Image src is: [" + imageURL + "] Image is NOT displayed!");
        }
      }
    } catch (Exception e) {
      System.out.println("Exception: [" + e.getMessage() + "]");
      //throw new RuntimeException(e);
    } return this;
  }
}
