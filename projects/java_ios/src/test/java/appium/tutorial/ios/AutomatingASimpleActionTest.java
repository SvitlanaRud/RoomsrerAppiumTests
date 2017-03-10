package appium.tutorial.ios;

import appium.tutorial.ios.util.AppiumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static appium.tutorial.ios.util.Helpers.*;

public class AutomatingASimpleActionTest extends AppiumTest {


    @org.junit.Test
    public void signInPage() throws Exception {
        element(By.name("“Roomster” Would Like to Send You Notifications"));
        element(By.name("Allow")).click();
        element(By.name("There is a new version of the Roomster App available. Update now!"));
        element(By.name("Cancel")).click();
        element(By.name("welcome_logo"));
        element(By.name("Find great places & people to share a home with."));
        element(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]"));
        element(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypePageIndicator[1]"));
        element(By.name("more info icon"));
        element(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextView[1]"));
    }

    @org.junit.Test
    public void moreInfo() throws Exception {
        signInPage();
        element(By.name("more info icon")).click();
        element(By.name("Why do I need to sign in with Facebook?"));
        element(By.name("more info icon")).click();

    }

    @org.junit.Test
    public void terms() throws Exception {
        signInPage();
        element(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextView[1]")).click();
        element(By.name("RMTermsAndPrivacyView"));
        element(By.name("Done")).click();
    }

    @org.junit.Test
    public void tutorials() throws Exception {

        signInPage();
        element(By.name("Find great places & people to share a home with."));
        swipingHorizontal();
        text_exact("Wherever you are");
        swipingHorizontal();
        text_exact("A room of your own");
        swipingHorizontal();
    }

    @org.junit.Test
    public void loginForNewUser() throws Exception {

        signInPage();
        element(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")).click();
        setWait(60);
        element(By.name("Confirm"));
        setWait(60);
        element(By.name("OK")).click();

        element(By.name("overlay OK button")).click();
    }
/*



hhhhhhhhh
    @org.junit.Test
    public void overlay () throws Exception {
        signInPage();
        setWait(60);
        element(By.name("overlay_settings_arrow"));
        element(By.name("settings"));
        element(By.name("overlay_messages_arrow"));
        element(By.name("messages"));
        element(By.name("bookmark"));
        element(By.name("overlay_bookmark_arrow"));
        element(By.name("Swipe left or right to view listings"));
        element(By.name("overlay_swipe_left_arrow"));
        element(By.name("overlay_swipe_right_arrow"));
        element(By.name("Choose different ways to contact"));
        element(By.name("overlay_ways_to_contact_arrow"));
        element(By.name("tabbar-message-icon"));
        element(By.name("Message"));
        element(By.name("abbar-phone-icon"));
        element(By.name("Call"));
        element(By.name("abbar-SMS-icon"));
        element(By.name("SMS"));
        element(By.name("tabbar-social-icon"));
        element(By.name("Social"));
        element(By.name("tabbar-other-icon"));
        element(By.name("Other"));
        element(By.name("overlay OK button")).click();


    }
*/


/*
        wait(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"));
        setWait(30);
        element(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]")).click();
        element(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[1]")).sendKeys("andreyb@tundramobile.com");
        element(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[2]")).sendKeys("tundra88");
        find("Log In").click();
        wait(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[4]/android.view.View[4]")); // waiting for the element to be clickable
        element(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[4]/android.view.View[4]")).click();
        wait(By.id("com.roomster:id/main_toolbar"));
    }

    @org.junit.Test
    public void two() throws Exception {
        wait(for_text("Buttons, Various uses of UIButton")).click();
        wait(for_text_exact("Buttons"));
    }

    @org.junit.Test
    public void three() throws Exception {
        WebElement cell_1 = wait(for_text(2));
        String page_title = cell_1.getAttribute("name").split(",")[0];

        cell_1.click();
        wait(for_text_exact(page_title));
    }

    @org.junit.Test
    public void four() throws Exception {
        List<String> cell_names = new ArrayList<String>();

        for (WebElement cell : tags("UIATableCell")) {
            cell_names.add(cell.getAttribute("name"));
        }

        for (String name : cell_names) {
            wait(for_text_exact(name)).click();
            wait(for_text_exact(name.split(",")[0]));
            back();
        }
    }
*/
}