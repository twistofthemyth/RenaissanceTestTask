package ru.twistofthemyth.page.app;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.support.FindBy;
import ru.twistofthemyth.annotation.WrappedElement;
import ru.twistofthemyth.elements.ClickableElement;
import ru.twistofthemyth.elements.SelectElement;
import ru.twistofthemyth.elements.TextElement;
import ru.twistofthemyth.page.PageBase;
import ru.twistofthemyth.service.DriverHolder;

public class CardsApplicationPage extends PageBase {
    public CardsApplicationPage(@NotNull DriverHolder driver) {
        super(driver);
    }

    @WrappedElement(name = "Фамилия", essential = true)
    @FindBy(xpath = "//input[@name='ClientLastName']")
    public TextElement clientLastName;

    @WrappedElement(name = "Имя", essential = true)
    @FindBy(xpath = "//input[@name='ClientName']")
    public TextElement clientName;

    @WrappedElement(name = "Телефон", essential = true)
    @FindBy(xpath = "//input[@name='ClientMobilePhone']")
    public TextElement clientMobilePhone;

    @WrappedElement(name = "Почта", essential = true)
    @FindBy(xpath = "//input[@name='AdditionalEmail']")
    public TextElement additionalEmail;

    @WrappedElement(name = "Нет отчества", essential = true)
    @FindBy(xpath = "//input[@name='ClientSecondName']/..//div[@class='jq-checkbox__div']/preceding-sibling::input")
    public ClickableElement noClientSecondName;

    @WrappedElement(name = "Где вы желаете получить карту?", essential = true)
    @FindBy(xpath = "//select[@name='CreditRegion']")
    public SelectElement creditRegion;

    @Step("Заполнить форму заявки на оформление карты произвольными значениям")
    public CardsApplicationPage performSomeActions() {
        clientLastName.fill("Тестович");
        clientName.fill("Тест");
        clientName.fill("8005553535");
        noClientSecondName.actionClick();
        creditRegion.select("Ханты-Мансийский АО");
        driver.saveScreenshot();
        return this;
    }

}
