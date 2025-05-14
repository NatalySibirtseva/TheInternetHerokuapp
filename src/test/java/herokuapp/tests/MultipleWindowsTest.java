package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import herokuapp.pages.MultipleWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getMultipleWindows();
    }

    @Test
    public void newTabTest() {
        new MultipleWindowsPage(app.driver, app.wait).switchToNewTab(1)
                .verifyNewTabTitle("New Window");
    }
}
