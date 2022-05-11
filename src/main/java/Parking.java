import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Parking {
    public WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        BasicConfigurator.configure();
        driver.get("https://www.shino.de/parkcalc/");
    }
    @DataProvider(name = "data")
    public Object[][] Method(){
        return new Object[][]{
                {"Economy Parking", "2/14/2022", "11:00", "AM", "2/20/2022", "11:00", "PM"},
                {"Valet Parking", "1/1/2022", "9:00", "PM", "1/2/2022", "11:00", "AM"},
                {"Short-Term Parking", "5/6/2022", "10:00", "AM", "5/20/2022", "10:00", "PM"},
                {"Long-Term Garage Parking", "7/22/2022", "8:00", "AM", "7/22/2022", "11:00", "PM"}
        };
    }
    @Test (dataProvider = "data")
    public void Test(String parkingLot1, String date1pr, String time1pr, String val1,
                      String date2pr, String time2pr, String val2)
    {
        WebElement parkingLot = driver.findElement(By.xpath("ParkingLot"));
        parkingLot.sendKeys(parkingLot1);
        WebElement date1 = driver.findElement(By.name("StartingDate"));
        date1.clear();
        date1.sendKeys(date1pr);
        WebElement time1 = driver.findElement(By.name("StartingTime"));
        time1.clear();
        time1.sendKeys(time1pr);
        WebElement r1 = driver.findElement(By.xpath("//input[@name='StartingTimeAMPM'][@value='" + val1 + "']"));
        r1.click();
        WebElement date2 = driver.findElement(By.name("LeavingDate"));
        date2.clear();
        date2.sendKeys(date2pr);
        WebElement time2 = driver.findElement(By.name("LeavingTime"));
        time2.clear();
        time2.sendKeys(time2pr);
        WebElement r2 = driver.findElement(By.xpath("//input[@name='LeavingTimeAMPM'][@value='" + val2 + "']"));
        r2.click();

        WebElement button = driver.findElement(By.name("Submit"));
        button.click();

    }


}
