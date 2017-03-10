package appium.tutorial.android.page;

import static appium.tutorial.android.util.Helpers.find;
import static appium.tutorial.android.util.Helpers.setWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/** Page object for the home page **/
public abstract class HomePage {

    /** Verify the home page has loaded.
     *  Click the accessibility button.
     *  Verify the accessibility page has loaded. **/

    public static void login() {

        LoginPage.loaded();
        find("com.roomster:id/facebook_login_btn_layout").click();
        FacebookLoginPage.loaded();
    }


    /** Verify the home page has loaded.
     *  Click the animation button.
     *  Verify the animation page has loaded. **/
    public static void facebookLogin() {
        loaded();

        FacebookLoginPage.loaded();
    }

    /** Verify the home page has loaded **/
    public static void loaded() {
        find("NFC");
    }


}