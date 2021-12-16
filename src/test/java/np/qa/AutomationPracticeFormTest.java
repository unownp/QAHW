package np.qa;

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
    }

    @Test
    void practiceFormTest() {
        open("https://demoqa.com/automation-practice-form");

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

        $("#subjectsInput").setValue("Civics").pressEnter();

        $("[for='hobbies-checkbox-1']").click();

        File file = new File("src/test/resources/scale_1200.jpg");
        Selenide.$(byId("uploadPicture")).uploadFile(file);

        $("#currentAddress").setValue("OuterSpace");

        $("#react-select-3-input").setValue("u").pressEnter();
        $("#react-select-4-input").setValue("l").pressEnter();

        $("#close-fixedban").click();
        $("#submit").click();

        checkTable();

    }

    void checkTable() {
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Forrest"));
        $(".table-responsive").shouldHave(text("Gump"));
        $(".table-responsive").shouldHave(text("stupid@orsomething.com"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("8800555353"));
        $(".table-responsive").shouldHave(text("01 May,1900"));
        $(".table-responsive").shouldHave(text("Civics"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("scale_1200.jpg"));
        $(".table-responsive").shouldHave(text("OuterSpace"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Lucknow"));
    }
}
