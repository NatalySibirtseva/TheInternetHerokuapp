package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(className = "icon-signout")
    WebElement logOutTextValue;

    public ProfilePage verifyLogOutText(String text) {
        String expectedText = text;
        String actualText = logOutTextValue.getText();
        String errorMessage = "\nExpected text: " + expectedText + ",\nActual text: " + actualText;
        Assert.assertTrue(actualText.contains(expectedText), errorMessage);
        return this;
    }
}
