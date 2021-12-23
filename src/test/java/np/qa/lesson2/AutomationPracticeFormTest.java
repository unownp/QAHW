package np.qa.lesson2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Forrest");
        $("#lastName").setValue("Gump");
        $("#userEmail").setValue("stupid@orsomething.com");

        $("[for='gender-radio-3']").click();

        $("#userNumber").setValue("8800555353");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value='4']").click();
        $(".react-datepicker__year-select").click();
        $("[value='1900']").click();
        $(".react-datepicker__day--001").click();

        $("#subjectsInput").setValue("i");
       // $("#react-select-2-option-3").click();
       // $("[class='subjects-auto-complete__menu css-26l3qy-menu']").scrollTo();
        $("#react-select-2-option-10").click();

        $("[for='hobbies-checkbox-1']").click();

        File file = new File("src/test/resources/scale_1200.jpg");
        $(byId("uploadPicture")).uploadFile(file);

        $("#currentAddress").setValue("OuterSpace");

        $("#react-select-3-input").setValue("u").pressEnter();
        $("#react-select-4-input").setValue("l").pressEnter();

        $("#close-fixedban").click();
        $("#submit").click();

        checkTable();

    }

    void checkTable() {
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Forrest"),text("Gump"),text("stupid@orsomething.com"),
                text("Other"),text("8800555353"),
                text("8800555353"),text("01 May,1900"),
                text("Civics"),text("Sports"),
                text("scale_1200.jpg"),text("OuterSpace"),
                text("Uttar Pradesh Lucknow"));

    }
}
