package ru.twistofthemyth.page.home.navbar;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.twistofthemyth.annotation.WrappedElement;
import ru.twistofthemyth.elements.ClickableElement;
import ru.twistofthemyth.page.PageBase;
import ru.twistofthemyth.page.cards.CardsPage;
import ru.twistofthemyth.service.DriverHolder;

public class Cards extends PageBase {

    public Cards(DriverHolder driver) {
        super(driver);
    }

    @WrappedElement(name = "Выбрать карту", essential = true)
    @FindBy(xpath = "//a[contains(@href,'https://rencredit.ru/cards/') and contains(text(), 'Выбрать карту')]")
    public ClickableElement chooseCardLink;

    @Step("Перейти на страницу выбора карт")
    public CardsPage choseCard() {
        chooseCardLink.click();
        return new CardsPage(driver);
    }

}
