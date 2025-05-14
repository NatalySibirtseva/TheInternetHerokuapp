package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.FramesPage;
import herokuapp.pages.HomePage;
import herokuapp.pages.NestedFramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver, app.wait).getFrames();
        new FramesPage(app.driver, app.wait).getNestedFrames();
    }

    @Test
    public void nestedFramesTest(){
        new NestedFramesPage(app.driver, app.wait).handleNestedNames();

    }

}
