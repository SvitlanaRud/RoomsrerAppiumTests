package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;


import static appium.tutorial.android.util.Helpers.*;

public class AutomatingASimpleActionTest extends AppiumTest {


    @org.junit.Test
    public void signInPage() throws Exception {
        element(By.id("com.roomster:id/tv_text"));
        element(By.id("com.roomster:id/pagerIndicator"));
        element (By.id("com.roomster:id/facebook_login_btn_layout"));
        element(By.id("com.roomster:id/btn_more_info"));
        element(By.id("com.roomster:id/terms_and_privacy"));
    }

    @org.junit.Test
    public void moreInfo() throws Exception {
        element(By.id("com.roomster:id/btn_more_info")).click();
        element(By.id("com.roomster:id/info_bubble"));
        element(By.id("com.roomster:id/btn_more_info")).click();
    }

    @org.junit.Test
    public void terms() throws Exception {
        element(By.id("com.roomster:id/terms")).click();
        element(By.id("com.roomster:id/rl_content"));
        back();
    }

    @org.junit.Test
    public void tutorials() throws Exception {

        element(By.id("com.roomster:id/facebook_login_btn_layout"));
        swipingHorizontal();
        text_exact("Wherever you are");
        swipingHorizontal();
        text_exact("A room of your own");
        swipingHorizontal();
    }


    @org.junit.Test
    public void login() throws Exception {


        element(By.id("com.roomster:id/facebook_login_btn_layout")).click();
        setWait(60);
        wait(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"));
        setWait(30);
        System.out.println(" Context " + driver.getContextHandles());
        element(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]")).click();
        element(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[1]")).sendKeys("andreyb@tundramobile.com");
        element(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[2]")).sendKeys("tundra88");
        find("Log In").click();
        wait(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[4]/android.view.View[4]")); // waiting for the element to be clickable
        System.out.println(driver.getPageSource()); // get the page source
        element(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[4]/android.view.View[4]")).click();
        wait(By.id("com.roomster:id/main_toolbar"));
    }


    @org.junit.Test
    public void exploreListings() throws Exception {
        login();
        element(By.id("com.roomster:id/detailed_view_toolbar_container"));
        element(By.id("com.roomster:id/vertical_pager_indicator"));
        element(By.id("com.roomster:id/iv_bookmark"));
        element(By.id("com.roomster:id/profile_pic"));
        element(By.id("com.roomster:id/main_toolbar"));
        swipingHorizontal();
        element(By.id("com.roomster:id/bottom_view_scroll")).click();
        element(By.id("com.roomster:id/bs_expanded_header"));
        element(By.id("com.roomster:id/bs_description_layout"));
    }

    @org.junit.Test
    public void listingExpanded() throws Exception {
        login();
        element(By.id("com.roomster:id/bottom_view_scroll")).click();
        element(By.id("com.roomster:id/bs_iv_name"));
        element(By.id("com.roomster:id/bs_iv_gender"));
        element(By.id("com.roomster:id/listing_headline_text"));
        element(By.id("com.roomster:id/bs_iv_price_layout"));
        element(By.id("com.roomster:id/listing_type"));
        element(By.id("com.roomster:id/bs_iv_summary_text"));
        element(By.id("com.roomster:id/bs_iv_description_title_layout"));
        element(By.id("com.roomster:id/bs_iv_description_text"));
        element(By.id("com.roomster:id/bs_residence_title_layout"));
        element(By.id("com.roomster:id/bs_residence_items_layout"));

    }

    @org.junit.Test

    public void bottomMenu() throws Exception {
        login();
        element(By.id("com.roomster:id/contact_action_message"));
        element(By.id("com.roomster:id/contact_action_call"));
        element(By.id("com.roomster:id/contact_action_sms"));
        element(By.id("com.roomster:id/contact_action_social"));
        element(By.id("com.roomster:id/contact_action_other"));
        element(By.id("com.roomster:id/contact_action_message")).click();
        element(By.id("com.roomster:id/customPanel")).sendKeys("test");
        element(By.id("android:id/button1")).click();
    }
}


        //This is the first method in the HomePage class. The method starts by asserting that the app is on the home page. loaded(); in this context is the same as HomePage.loaded(); After that, we’re finding the “Accessibility” element by name then clicking on it. Finally, the code asserts the app is on the accessibility page. The AccessibilityPage page object defines the assert methods:

       /*
        @org.junit.Test
        public void two() throws Exception {
            wait(for_text("Accessibility")).click();
            wait(for_text_exact("Accessibility Node Provider"));
        }

        @org.junit.Test
        public void three() throws Exception {
            wait(for_text(2)).click();
            find("Custom Evaluator");
        }

        @org.junit.Test
        public void four() throws Exception {
            setWait(0);

            List<String> cell_names = new ArrayList<String>();

            for (WebElement cell : tags("android.widget.TextView")) {
                cell_names.add(cell.getAttribute("name"));
            }

            // delete title cell
            cell_names.remove(0);

            for (String cell_name : cell_names) {
                scroll_to_exact(cell_name).click();
                waitInvisible(for_text_exact(cell_name));
                back();
                wait(for_find("Accessibility"));
                wait(for_find("Animation"));
            }
*/



