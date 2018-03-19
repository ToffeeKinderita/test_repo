package pages;

import helpers.RandomStringGenerator;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.RandomStringGenerator.generateRandomString;

public class CreateUserClass {
    public static String numOfFamilies, numOfStaff;


    private static Boolean scrollPage() {

        return (Boolean) executeJavaScript("scroll(0,500)");
    }

    public static int checkNumberOfFamiliesStaff(String id) {
        //# of Families:
        if (Objects.equals(id, "family")) {
            numOfFamilies = getWebDriver().findElement(By.xpath("//span[text()='# of Families:']/../div/span")).getText();
            return Integer.parseInt(numOfFamilies);
        } //# of Staff:
        else if (Objects.equals(id, "staff")) {
            numOfStaff = getWebDriver().findElement(By.xpath("//span[text()='# of Staff:']/../div/span")).getText();
            return Integer.parseInt(numOfStaff);
        }
        return 0;
    }


    public static void fillFirstAndLastName(RandomStringGenerator.Mode last, RandomStringGenerator.Mode first) {
        lastName(last);
        firstName(first);


    }

    public static void createUserWithAllFields(RandomStringGenerator.Mode last, RandomStringGenerator.Mode first, String spouse, String prEmail, String secEmail,
                                               String prStreet, String prCity, String prState, String prZip, String prCountry, String secStreet, String secCity,
                                               String secState, String secZip, String secCountry) {
        fillFirstAndLastName(last,first);
        fillSpouse(spouse);
        fillPrSecPhones();
        fillPrSecEmail(prEmail, secEmail);
        scrollPage();
        fillPrimaryAddress(prStreet, prCity, prState, prZip, prCountry);
        fillSecondaryAddress(secStreet, secCity, secState, secZip, secCountry);
    }

    public static void fillSpouse(String spouse) {
        $(By.id("spouse")).sendKeys(spouse);
    }
    public static void lastName(RandomStringGenerator.Mode last) {
        $(By.id("lastName")).sendKeys(generateRandomString(4,last));

    }
    public static void firstName(RandomStringGenerator.Mode  first) {
        $(By.xpath("//input[@id='firstName']|//input[@id='headOfHousehold']")).sendKeys(generateRandomString(5,first));

    }



    public static void fillChildren(int plus, RandomStringGenerator.Mode Mode) {
        for (int i = 1; i < plus; i++) {
            $(By.xpath("//span[text()='Children']/../div/button")).click();
            $(By.xpath("//label[text()='Child " +i +"']/../input")).sendKeys(generateRandomString(5, Mode));
        }
    }

    public static void fillPrSecPhones() {
        $(byCssSelector("[name|=primaryPhone]")).sendKeys(generateRandomString(10, RandomStringGenerator.Mode.NUMERIC));
        $(byCssSelector("[name|=secondaryPhone]")).sendKeys(generateRandomString(10, RandomStringGenerator.Mode.NUMERIC));

    }

    public static void fillPrSecPhonesNonNumeric(String phone) {
        $(byCssSelector("[name|=primaryPhone]")).sendKeys(generateRandomString(10, RandomStringGenerator.Mode.ALPHA));
        $(byCssSelector("[name|=secondaryPhone]")).sendKeys(phone);

    }

    public static void fillPrSecEmail(String prEmail, String secEmail) {
        $(byCssSelector("[name|=primaryEmail]")).sendKeys(prEmail);
        $(byCssSelector("[name|=secondaryEmail]")).sendKeys(secEmail);

    }

    public static void fillPrimaryAddress(String prStreet, String prCity, String prState, String prZip, String prCountry) {
        $(byCssSelector("[name|='primaryAddress.street']")).sendKeys(prStreet);
        $(byCssSelector("[name|='primaryAddress.city']")).sendKeys(prCity);
        $(byCssSelector("[name|='primaryAddress.stateProvince']")).sendKeys(prState);
        $(byCssSelector("[name|='primaryAddress.zip']")).sendKeys(prZip);
        $(byCssSelector("[name|='primaryAddress.country']")).sendKeys(prCountry);
    }

    public static void fillSecondaryAddress(String secStreet, String secCity, String secState, String secZip, String secCountry) {
        $(byCssSelector("[name|='secondaryAddress.street']")).sendKeys(secStreet);
        $(byCssSelector("[name|='secondaryAddress.city']")).sendKeys(secCity);
        $(byCssSelector("[name|='secondaryAddress.stateProvince']")).sendKeys(secState);
        $(byCssSelector("[name|='secondaryAddress.zip']")).sendKeys(secZip);
        $(byCssSelector("[name|='secondaryAddress.country']")).sendKeys(secCountry);
    }

    public static String errorFirstName() {
        return $(By.id("headOfHousehold-error")).getText();
    }

    public static String errorLastName() {
        return $(By.id("lastName-error")).getText();
    }

}

