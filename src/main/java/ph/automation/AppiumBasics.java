package ph.automation;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AppiumBasics {

    @Test
    public void AppiumTest() throws MalformedURLException {

        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//kevin//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexus 5X API 33");
        options.setApp("C://Users//kevin//IdeaProjects//appium//src//test//java//resources//ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.quit();

        service.stop();

    }

}
