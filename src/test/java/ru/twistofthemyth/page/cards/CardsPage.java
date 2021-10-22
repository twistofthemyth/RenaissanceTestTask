package ru.twistofthemyth.page.cards;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.twistofthemyth.annotation.WrappedElement;
import ru.twistofthemyth.elements.ClickableElement;
import ru.twistofthemyth.page.PageBase;
import ru.twistofthemyth.page.app.CardsApplicationPage;
import ru.twistofthemyth.service.DriverHolder;

public class CardsPage extends PageBase {

    public CardsPage(@NotNull DriverHolder driver) {
        super(driver);
    }

    @WrappedElement(name="Оформить карту", essential = true)
    @FindBy(xpath = "//a[@href='https://rencredit.ru/app/card/creditcardpractic']")
    public ClickableElement practicCardLink;

    @Step("Перейти к оформлению заявки на карту \"Практичная\"")
    public @NotNull CardsApplicationPage choosePracticCard() {
        practicCardLink.click();
        return new CardsApplicationPage(driver);
    }
}
