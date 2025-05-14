package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class iFramePage extends BasePage {
    public iFramePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "mce_0_ifr")
    WebElement iFrameId;


    public iFramePage switchToFrameById() {
        driver.switchTo().frame(iFrameId);
        return this;
    }

    @FindBy(xpath = "//body[@id = 'tinymce']/p")
    WebElement textIFrame;

    public iFramePage verifyIframeByText(String text) {
        Assert.assertTrue(textIFrame.getText().contains(text));
        return this;
    }

    public iFramePage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "h3")
    WebElement title;

    public iFramePage verifyMainPageByTitle(String text) {
        Assert.assertTrue(title.getText().contains(text));
        return this;
    }
}
