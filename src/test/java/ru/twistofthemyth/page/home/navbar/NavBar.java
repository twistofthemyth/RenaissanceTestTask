package ru.twistofthemyth.page.home.navbar;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.twistofthemyth.annotation.WrappedElement;
import ru.twistofthemyth.elements.ClickableElement;
import ru.twistofthemyth.page.PageBase;
import ru.twistofthemyth.service.DriverHolder;

public class NavBar extends PageBase {

    public NavBar(DriverHolder driver) {
        super(driver);
    }

    @WrappedElement(name = "Кредиты")
    @FindBy(xpath = "//div[contains(@class, 'site-header__content-bottom-body')]//span[contains(text(), 'Кредиты')]/..")
    public ClickableElement credits;

    @WrappedElement(name = "Карты")
    @FindBy(xpath = "//div[contains(@class, 'site-header__content-bottom-body')]//span[contains(text(), 'Карты')]/..")
    public ClickableElement cards;

    @WrappedElement(name = "Вклады")
    @FindBy(xpath = "//div[contains(@class, 'site-header__content-bottom-body')]//span[contains(text(), 'Вклады')]/..")
    public ClickableElement deposits;

    //other pages and elements


    @Step("На навбаре выбрать \"Вклады\"")
    public Deposits openDeposits() {
        deposits.click();
        return new Deposits(driver);
    }

    @Step("На навбаре выбрать \"Карты\"")
    public Cards openCards() {
        cards.click();
        return new Cards(driver);
    }
}
