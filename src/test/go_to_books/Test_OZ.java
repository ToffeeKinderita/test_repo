package go_to_books;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Oz;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test_OZ extends Oz {
    @Test
    public void openBooks (){
        open(oz);
        $(By.cssSelector(".main-nav__list>li>a[href=\"/books/\"]")).click();
        $(By.cssSelector(" li.landing-nav-list__item:first-child")).click();
        String a = $(By.cssSelector(".breadcrumbs__list.setanim li:last-child span")).getText();
        Assert.assertTrue(a.contains("Бестселлеры книг"));
        System.out.println("test");

    }

}
