package gestures;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TapAction {

    @Test
    public void capTest() throws MalformedURLException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability("deviceName", "VertialPhonePixel");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("app", apkFile.getAbsolutePath());
        URL serverUrl = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(serverUrl, caps);

        WebElement viewsButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        TouchAction touchAction = new TouchAction<>(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();

        WebElement expandableListsButton = driver.findElementByAccessibilityId("Expandable Lists");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableListsButton))).perform();

        WebElement customAdapterButton = driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapterButton))).perform();

        WebElement peopleNamesButton = driver.findElement(By.xpath("//*[@text='People Names']"));
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNamesButton)).withDuration(Duration.ofSeconds(2))).perform();

        WebElement sampleMenuButton = driver.findElement(By.xpath("//*[@text='Sample menu']"));
        Assert.assertTrue(sampleMenuButton.isEnabled());

    }


    @Test
    public void scrollTest() throws MalformedURLException {

       File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
       DesiredCapabilities caps=new DesiredCapabilities();
       caps.setCapability("deviceName","VertialPhonePixel");
       caps.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
       caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
       caps.setPlatform(Platform.ANDROID);

       URL appiumServerUrl=new URL("http://0.0.0.0:4723/wd/hub");
       AndroidDriver driver = new AndroidDriver(appiumServerUrl,caps);
        Actions actions=new Actions(driver);

        WebElement viewsButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        TouchAction touchAction= new TouchAction(driver);
       touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();

       driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"))");
       WebElement tabButton = driver.findElementByAccessibilityId("Tabs");
       tabButton.click();




    }


}
