package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends BasePage {
    public MultipleWindowsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[.='Click Here']")
    WebElement tabLink;

    public MultipleWindowsPage switchToNewTab(int index) {
        click(tabLink);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(css = "h3")
    WebElement tabTitle;

    public MultipleWindowsPage verifyNewTabTitle(String text) {
        Assert.assertTrue(shouldHaveText(tabTitle, text, 1));
        return this;
    }
}
