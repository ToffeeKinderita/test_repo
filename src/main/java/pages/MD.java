package pages;

import helpers.TestBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MD extends TestBase {
    protected static final String MD_HOST_URL = "https://qamobiledirectory.lifetouch.net/123/a-selenium-test-church/admin/authenticate";
    protected static final String MD_MANAGE_URL = "https://qamobiledirectory.lifetouch.net/manage";

    public static void login(String username, String password) {
        $(By.id("username")).sendKeys(username);
        $(By.id("password")).sendKeys(password);
        $(By.xpath("//button[text()='Login']")).click();

    }
}
