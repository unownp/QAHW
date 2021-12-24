package np.qa.lesson3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWikiTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        baseUrl = "https://github.com";

    }

    /*
    1)

    $("h1 div") - найдет, тк во втором h1 есть div.
    $("h1").$("div") - не найдет, тк только смотрит на первый h1

    <h1> <ol>
        <\ol> <\h1>

    <h1> <div>
        <\div> <\h1>

    */


    @Test
    void selenideWikiTest() {
        open(baseUrl);
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("h1").shouldHave(text("Selenide / Selenide"));
        $("#wiki-tab").click();
        $("#wiki-pages-box").$("li.Box-row.wiki-more-pages-link").$("button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions")).shouldBe(visible);
        $("#wiki-pages-box").find(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5"));
    }

}
