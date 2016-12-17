import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by optikool on 12/17/2016.
 */
public class Google {
    private WebDriver driver;
    private String baseURL;

    public Google(WebDriver driver) {
        this.driver = driver;
        baseURL = "https://wwww.google.com/";
        driver.get(baseURL + "webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=google%20temperature%20converter");
        System.out.println(driver.getTitle());

        if (!driver.getTitle().equals("Google")){
            throw new WrongPageException("Incorrect page for Google Home page");
        }
    }

    public TemperatureConverterPage goToTemperatureConversionPage(){
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("from fahrenheit to celsius");
        driver.findElement(By.name("btnG")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        return new TemperatureConverterPage(driver);
    }
}
