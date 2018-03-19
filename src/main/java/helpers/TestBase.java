package helpers;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;

public class TestBase {
    @BeforeMethod(alwaysRun = true)
    public void setup() {
        String log4jConfPath = "D:\\test_repo\\src\\main\\resources\\lod4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        Configuration.browser =System.getProperty("browser", "chrome");
        }

    @AfterMethod
    public void quit() {
        close();
    }
}
