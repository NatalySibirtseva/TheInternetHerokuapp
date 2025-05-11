package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JSAlertsPage extends BasePage {
    public JSAlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//button[.='Click for JS Alert']")
    WebElement buttonJsAlert;

    public JSAlertsPage JsAlert() {
        click(buttonJsAlert);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    WebElement buttonJsConfirm;

    public JSAlertsPage JsOKConfirm() {
        click(buttonJsConfirm);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    public JSAlertsPage JsCancelConfirm() {
        click(buttonJsConfirm);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.alertIsPresent()).dismiss();
        return this;
    }

    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    WebElement buttonJsPrompt;

    public JSAlertsPage JsOKPrompt() {
        click(buttonJsPrompt);
        Alert prompt = new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.alertIsPresent());
        prompt.sendKeys("My text");
        prompt.accept();
        return this;
    }

    public JSAlertsPage JsCancelPrompt() {
        click(buttonJsPrompt);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.alertIsPresent()).dismiss();
        return this;
    }

    @FindBy(id = "result")
    WebElement textResultOfAlert;

    public JSAlertsPage verifyTextResultOfAlerts(String text) {
        String expectedText = text;
        String actualText = textResultOfAlert.getText();
        String errorMessage = "\nExpected text: " + expectedText + ",\nActual text: " + actualText;
        Assert.assertTrue(actualText.contains(expectedText), errorMessage);
        return this;
    }

}
