package guru.qa.niffler.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {

    private final ElementsCollection rowsTableSpending = $(".spendings-table tbody").$$("tr");

    private final SelenideElement deletedButton = $(".spendings__bulk-actions button");


    @Step("Выбор строки в таблице по описанию")
    public MainPage choosingRowByDescription (String description){
        SelenideElement rowWithSpending = rowsTableSpending.find(text(description));
        sleep(55500);
        rowWithSpending.$("td").scrollIntoView(true).click();
        return this;
    }

    @Step("Кликнуть кнопку удалить")
    public MainPage deleteSpending(){

        deletedButton.shouldBe(enabled, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Проверка размера таблицы покупок")
    public void checkSizeSpendingTable(int size){
        rowsTableSpending.shouldHave(size(size));
    }


}
