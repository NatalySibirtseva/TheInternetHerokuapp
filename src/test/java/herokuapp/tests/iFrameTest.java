package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.FramesPage;
import herokuapp.pages.HomePage;
import herokuapp.pages.iFramePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getFrames();
        new FramesPage(app.driver, app.wait).getIFrames();
    }

    @Test
    public void iFrameTest(){
        new iFramePage(app.driver, app.wait).switchToFrameById()
                .verifyIframeByText("Your content goes here.")
                .switchToMainPage()
                .verifyMainPageByTitle("An iFrame containing the TinyMCE WYSIWYG Editor");
    }
}
