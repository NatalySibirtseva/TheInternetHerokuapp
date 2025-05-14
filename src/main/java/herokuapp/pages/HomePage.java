package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[.='Form Authentication']")
    WebElement liFormAuthentication;

    public LoginPage getFormAuthentication() {
        click(liFormAuthentication);
        return new LoginPage(driver, wait);
    }

    @FindBy(xpath = "//a[.='JavaScript Alerts']")
    WebElement liJavaScriptAlerts;

    public JSAlertsPage getJavaScriptAlerts(){
        click(liJavaScriptAlerts);
        return new JSAlertsPage(driver, wait);
    }

    @FindBy(xpath = "//a[.='Frames']")
    WebElement liFrames;

    public FramesPage getFrames() {
        click(liFrames);
        return new FramesPage(driver,wait);
    }

    @FindBy(xpath = "//a[.='Multiple Windows']")
    WebElement liMultipleWindows;

    public MultipleWindowsPage getMultipleWindows() {
        click(liMultipleWindows);
        return new MultipleWindowsPage(driver, wait);
    }
}
