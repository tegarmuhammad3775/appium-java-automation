package cucumber.stepDef;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class MyStepdefs {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseUrl = "http://127.0.0.1:4723/";

    @Given("Membuka Aplikasi")
    public void membukaAplikasi() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("app", System.getProperty("user.dir")+"/src/test/java/apk/Diet_meal.apk"); //set apk file directory
        capabilities.setCapability("autoGrantPermissions", true); // set auto accept permission request setting
        capabilities.setCapability("autoAcceptAlerts", true); // set auto accept all possible appearing alert
        capabilities.setCapability("automationName", "UiAutomator2");

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url,capabilities); //Open App

        //waiting
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @When("Input Data")
    public void inputData() {
        //proses flow 1
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/et_name")).sendKeys("My Skill");
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/et_weight")).sendKeys("55");
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/et_height")).sendKeys("175");
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/rb_male")).click();
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/bt_next")).click();
    }

    @And("Klik Lanjutkan")
    public void klikLanjutkan() {
        //proses flow 2
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/rb_medium")).click();
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/bt_finish")).click();
    }

    @Then("User di homepage")
    public void userDiHomepage() {
        //assertion
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/tv_header_name")).isDisplayed();
    }
}
