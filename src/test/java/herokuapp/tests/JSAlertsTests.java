package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.JSAlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSAlertsTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getJavaScriptAlerts();
    }

    @Test
    public void clickOnJsAlert() {
        new JSAlertsPage(app.driver, app.wait).JsAlert().verifyTextResultOfAlerts("You successfully clicked an alert");
    }

    @Test
    public void clickOKOnJsConfirm() {
        new JSAlertsPage(app.driver, app.wait).JsOKConfirm().verifyTextResultOfAlerts("You clicked: Ok");
    }

    @Test
    public void clickCancelOnJsConfirm() {
        new JSAlertsPage(app.driver, app.wait).JsCancelConfirm().verifyTextResultOfAlerts("You clicked: Cancel");
    }

    @Test
    public void clickOKOnJsPrompt() {
        new JSAlertsPage(app.driver, app.wait).JsOKPrompt().verifyTextResultOfAlerts("You entered: My text");
    }

    @Test
    public void clickCancelOnJsPrompt() {
        new JSAlertsPage(app.driver, app.wait).JsCancelPrompt().verifyTextResultOfAlerts("You entered: null");
    }
}
