package ph.automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;
   @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//kevin//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
//                .usingPort(4723).build();
                .usingAnyFreePort().build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexus 5X API 33");
        options.setApp("C://Users//kevin//IdeaProjects//appium//src//test//java//resources//ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
