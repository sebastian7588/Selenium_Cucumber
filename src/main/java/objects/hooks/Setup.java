package objects.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Setup {
    public static WebDriver driver;
    final PropertiesFile propertiesFile = new PropertiesFile();

    public File file = new File(propertiesFile.getProperties("cv_file"));

    public void scroll(WebElement element) {
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void timeOut(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void switchTab() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    //Metoda cookie do ulepszenia
    public void addCookie(String name,String value) {
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }

    public String getCurrentTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", propertiesFile.getProperties("chrome_driver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //tearDown do poprawy
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public void saveScreenshots() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("src/test/screenshot/"+timestamp()+".png"));
    }
}
