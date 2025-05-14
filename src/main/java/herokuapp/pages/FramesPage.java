package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[.='Nested Frames']")
    WebElement liNestedFrames;

    public NestedFramesPage getNestedFrames() {
        click(liNestedFrames);
        return new NestedFramesPage(driver, wait);
    }

    @FindBy(xpath = "//a[.='iFrame']")
    WebElement iFrame;

    public iFramePage getIFrames() {
        click(iFrame);
        return new iFramePage(driver, wait);
    }
}
