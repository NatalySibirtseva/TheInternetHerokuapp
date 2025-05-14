package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(tagName = "frame")
    List<WebElement> frame;

    @FindBy(xpath = "//frame[@name='frame-top']")
    WebElement frameTop;

    @FindBy(xpath = "//frame[@name='frame-bottom']")
    WebElement frameBottom;

    @FindBy(tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedNames() {
        driver.switchTo().frame(frameTop);
        System.out.println("Count of frames inside Top frameSet is: " + frame.size());
        driver.switchTo().frame(0);
        System.out.println("Text of 1 Frame is: " + body.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        System.out.println("Text of 2 Frame is: " + body.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println("Text of 3 Frame is: " + body.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameBottom);
        System.out.println("Text of Bottom Frame is: " + body.getText());
        return this;
    }
}
