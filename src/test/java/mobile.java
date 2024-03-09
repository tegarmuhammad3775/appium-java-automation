import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class mobile {
    public static AndroidDriver driver; //inisiasi android driver untuk appium
    public static DesiredCapabilities capabilities; //inisiasi desired capabilities
    public static String baseUrl = "https://127.0.0.1:4723/"; //base url mobile untuk appium v2

    @Test
    public void main() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("app", System.getProperty("user.dir")+"/src/test/java/apk/app_name.apk"); //set apk file directory
        capabilities.setCapability("autoGrantPermissions", true); // set auto accept permission request setting
        capabilities.setCapability("autoAcceptAlerts", true); // set auto accept all possible appearing alert
        capabilities.setCapability("automationName", "UiAutomator2");

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url,capabilities);
    }


}
