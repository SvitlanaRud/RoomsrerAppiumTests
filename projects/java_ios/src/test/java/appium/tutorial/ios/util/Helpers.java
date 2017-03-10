package appium.tutorial.ios.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Helpers {

  private static IOSDriver wd;
  public static URL serverAddress;
  public static WebDriverWait wdWait;

  /**
   * Initialize the webdriver. Must be called before using any helper methods. *
   */
  public static void init(IOSDriver webDriver, URL wdServerAddress) {
    wd = webDriver;
    serverAddress = wdServerAddress;
    int timeoutInSeconds = 60;
    // must wait at least 60 seconds for running on Sauce.
    // waiting for 30 seconds works locally however it fails on Sauce.
    wdWait = new WebDriverWait(webDriver, timeoutInSeconds);

  }
  public static void setWait(int seconds) {
    wd.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
  }

  /**
   * Wrap WebElement in MobileElement *
   */
  public static void swipingHorizontal() throws InterruptedException {
    Dimension size;

    //Get the size of screen.
    size = wd.manage().window().getSize();
    System.out.println(size);

    //Find swipe start and end point from screen's with and height.
    //Find startx point which is at right side of screen.
    int startx = (int) (size.width * 0.80);
    //Find endx point which is at left side of screen.
    int endx = (int) (size.width * 0.10);
    //Find vertical point where you wants to swipe. It is in middle of screen height.
    int starty = size.height / 2;
    System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

    //Swipe from Right to Left.
    wd.swipe(startx, starty, endx, starty, 600);
    Thread.sleep(500);
  }

  /**
   * Wrap WebElement in MobileElement *
   */
  private static List<MobileElement> w(List<WebElement> elements) {
    List list = new ArrayList(elements.size());
    for (WebElement element : elements) {
      list.add(w((List<WebElement>) element));
    }

    return list;
  }

  /**
   * Return an element by locator *
   */
  public static MobileElement element(By locator) {
    return (MobileElement) wd.findElement(locator);
  }

  /**
   * Return a list of elements by locator *
   */
  public static List<MobileElement> elements(By locator) {
    return w(wd.findElements(locator));
  }

  /**
   * Press the back button *
   */
  public static void back() {
    wd.navigate().back();
  }

  /**
   * Return a list of elements by tag name *
   */
  public static List<MobileElement> tags(String tagName) {
    return elements(for_tags(tagName));
  }

  /**
   * Return a tag name locator *
   */
  public static By for_tags(String tagName) {
    return By.className(tagName);
  }

  /**
   * Return a static text element by xpath index *
   */
  public static MobileElement text(int xpathIndex) {
    return element(for_text(xpathIndex));
  }

  /**
   * Return a static text locator by xpath index *
   */
  public static By for_text(int xpathIndex) {
    return By.xpath("//UIAStaticText[" + xpathIndex + "]");
  }

  /**
   * Return a static text element that contains text *
   */
  public static MobileElement text(String text) {
    return element(for_text(text));
  }

  /**
   * Return a static text locator that contains text *
   */
  public static By for_text(String text) {
    String up = text.toUpperCase();
    String down = text.toLowerCase();
    return By.xpath("//UIAStaticText[@visible=\"true\" and (contains(translate(@name,\"" + up
        + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@hint,\"" + up
        + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@label,\"" + up
        + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@value,\"" + up
        + "\",\"" + down + "\"), \"" + down + "\"))]");
  }

  /**
   * Return a static text element by exact text *
   */
  public static MobileElement text_exact(String text) {
    return element(for_text_exact(text));
  }

  /**
   * Return a static text locator by exact text *
   */
  public static By for_text_exact(String text) {
    return By.xpath("//UIAStaticText[@visible=\"true\" and (@name=\"" + text
        + "\" or @hint=\"" + text + "\" or @label=\"" + text
        + "\" or @value=\"" + text + "\")]");
  }

  /**
   * Wait 30 seconds for locator to find an element *
   */
  public static MobileElement wait(By locator) {
    return (MobileElement) w((List<WebElement>) wdWait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
  }

  /**
   * Wait 60 seconds for locator to find all elements *
   */
  public static List<MobileElement> waitAll(By locator) {
    return w(wdWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
  }
}