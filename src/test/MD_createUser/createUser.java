package MD_createUser;

import helpers.Waiter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MD;
import pages.UserInfoMd;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.PageBase.closeGuideTour;
import static helpers.PageBase.navigationMenu;
import static helpers.PageBase.saveBtn;
import static helpers.RandomStringGenerator.Mode.ALPHA;
import static helpers.RandomStringGenerator.Mode.LOWERCASE;
import static helpers.RandomStringGenerator.generateRandomString;
import static pages.CreateUserClass.*;

public class createUser extends MD {

        //private static SoftAssert s_assert = new SoftAssert();
        private static UserInfoMd testUser = new UserInfoMd() {
        };
        private static int before;

        @BeforeMethod
        public void start() {
            open(MD_HOST_URL);
            login("as","as");
            closeGuideTour();
            checkNumberOfFamiliesStaff("family");
            before = checkNumberOfFamiliesStaff("family");
            navigationMenu(By.xpath("//span[text()='Add family']"));
        }

        @Test
        @Features("CreateFamily")
        @TestCaseId("1.0.1")
        public static void crtF_WithRequiredFieldsTest() {
            fillFirstAndLastName(ALPHA, ALPHA);
            saveBtn();
            Waiter.waitForPageToLoad();
            checkNumberOfFamiliesStaff("family");
            int after = checkNumberOfFamiliesStaff("family");
            Assert.assertTrue(after == before + 1);
        }

        @Test
        @Features("CreateFamily")
        @TestCaseId("1.0.2")
        public static void crtF_WithAllFieldsTest() {
            createUserWithAllFields(ALPHA, ALPHA, testUser.getSpouse(), testUser.getPrEmail(), testUser.getSecEmail(),
                    testUser.getPrStreet(), testUser.getPrCity(), testUser.getPrState(), testUser.getPrZip(), testUser.getPrCountry(), testUser.getSecStreet(), testUser.getSecCity(),
                    testUser.getSecState(), testUser.getSecZip(), testUser.getSecCountry());
            saveBtn();
            Waiter.waitForPageToLoad();
            checkNumberOfFamiliesStaff("family");
            int after = checkNumberOfFamiliesStaff("family");
            Assert.assertTrue(after == before + 1);
        }


        @Test
        @Features("CreateFamily")
        @TestCaseId("1.0.3")
        public static void checkPhonesAreNumeric() {
            fillPrSecPhonesNonNumeric("03adnv04rt");
            Waiter.waitForPageToLoad();
            Assert.assertTrue($(byCssSelector("[name|=primaryPhone]")).getValue().isEmpty());
            Assert.assertTrue($(byCssSelector("[name|=secondaryPhone]")).getValue().contains("(030)-4"));
        }

        @Test
        @Features("CreateFamily")
        @TestCaseId("1.0.4")
        public static void checkPhonesHaveMask() {
            Assert.assertTrue($(byCssSelector("[name|=primaryPhone]")).getAttribute("placeholder").contains("(___)-___-____"));
            Assert.assertTrue($(byCssSelector("[name|=secondaryPhone]")).getAttribute("placeholder").contains("(___)-___-____"));
        }

        @Test
        @Features("CreateFamily")
        @TestCaseId("1.0.5")
        public static void checkNamesAllCapitals() {
            fillFirstAndLastName(LOWERCASE, LOWERCASE);
            fillSpouse(generateRandomString(8, LOWERCASE));
            fillChildren(2, LOWERCASE);
        }

        @Test
        @Features("CreateFamily")
        @TestCaseId("1.0.6")
        public static void crtF_NoReqrdFieldsTest() {
            saveBtn();
            Waiter.waitForPageToLoad();
            Assert.assertEquals(errorFirstName(), "This field is required.");
            Assert.assertEquals(errorLastName(), "This field is required.");
        }

        @Test
        @Features("CreateFamily")
        @TestCaseId("1.0.7")
        public static void crtF_OnlyLastNameTest() {
            lastName(ALPHA);
            saveBtn();
            Assert.assertEquals(errorFirstName(), "This field is required.");
        }

        @Test
        @Features("CreateFamily")
        @TestCaseId("1.0.8")
        public static void crtF_OnlyFirstNameTest() {
            firstName(ALPHA);
            saveBtn();
            Assert.assertEquals(errorLastName(), "This field is required.");
        }

    }
