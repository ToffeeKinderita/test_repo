package helpers;

import com.codeborne.selenide.Condition;
import helpers.Waiter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class PageBase {
    public static void shouldAppear(String title){
        Waiter.waitForPageTitle(title);
    }

    public static void checkExpectedElements(List<By> expectedElements){
        for(By element : expectedElements){
            $(element).shouldBe(Condition.visible);
        }}

    public static boolean isElementPresent(final By locator) {
        try{
            $(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public static void navigationMenu(By selector) {
        $(By.xpath("//*[@id='navbar-menu']")).click();
        $(selector).click();
        Waiter.waitForPageToLoad();
    }

    public static void closeGuideTour() {
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='step-0']")));
        $(By.xpath("//button[text()='End tour']")).click();
    }
    public static void saveBtn(){
        $(By.xpath("//button[text()=\"Save\"]")).click();
    }
}
