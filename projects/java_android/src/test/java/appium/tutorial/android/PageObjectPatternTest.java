package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
import org.junit.Test;

public class PageObjectPatternTest extends AppiumTest {

    @Test
    public void pageObject() throws Exception {
        home.login();


        home.facebookLogin();

    }
}