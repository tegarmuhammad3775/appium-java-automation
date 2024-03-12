package cucumber.mobilePage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class homePage {
    AndroidDriver driver;
    By nameForm = By.id("com.fghilmany.dietmealapp:id/et_name");
    By wegihtForm = By.id("com.fghilmany.dietmealapp:id/et_weight");
    By heightForm = By.id("com.fghilmany.dietmealapp:id/et_height");

    public homePage(AndroidDriver driver){
        this.driver = driver;
    }

    public void inputForm(String name, String weight, String height){
        driver.findElement(nameForm).sendKeys(name);
        driver.findElement(wegihtForm).sendKeys(weight);
        driver.findElement(heightForm).sendKeys(height);
    }
}
