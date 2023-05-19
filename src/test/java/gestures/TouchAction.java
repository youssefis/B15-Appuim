package gestures;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TouchAction {

    @Test
    public void touchAndMoveTest() throws MalformedURLException {

        File apkFile=new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"VertialPhonePixel");
        caps.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

        URL appiumServerUrl=new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl,caps);

        driver.findElementByAccessibilityId("Views").click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();

        WebElement hand=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='3']"));
        WebElement target3=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='3']"));

        new AndroidTouchAction(driver)
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(hand)))
                .moveTo(ElementOption.element(target3))
                .release()
                .perform();
        WebElement target45=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='45']"));
        new AndroidTouchAction(driver)
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(hand)))
                .moveTo(ElementOption.element(target45))
                .release()
                .perform();



    }

}
