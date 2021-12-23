package np.qa.lesson3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        baseUrl = "https://github.com";
    }

    // 1) разница есть: $("h1 div") - поиск по всему дереву,  $("h1").$("div") - только в первом уровне


    @Test
    void selenideWikiTest() {
        open(baseUrl);
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h1").shouldHave(text("Selenide / Selenide"));
        $("#wiki-tab").click();
        $$("#wiki-pages-box").first().$("li.Box-row.wiki-more-pages-link").$("button").click();
        $$("#wiki-pages-box").first().shouldHave(text("SoftAssertions")).shouldBe(visible);
        $$("#wiki-pages-box").first().find(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5"));
    }

}
