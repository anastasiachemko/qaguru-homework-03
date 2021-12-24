package com.gmail.chemko.nast;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkTests {

    @BeforeAll
    static void beforeAll() {Configuration.browserSize = "1920x1080";}

    @Test
    void jUnit5ExampleCodeSearchTest() {

        open("https://github.com/");

        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("h1").shouldHave(text("Selenide / Selenide"));
        $("#wiki-tab").click();
        $("#wiki-pages-box").$("li.Box-row.wiki-more-pages-link").$("button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));

    }

    @Test
    void dragAndDropTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}

