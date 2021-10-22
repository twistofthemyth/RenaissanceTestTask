package ru.twistofthemyth.page.home.navbar;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.support.FindBy;
import ru.twistofthemyth.annotation.Page;
import ru.twistofthemyth.annotation.WrappedElement;
import ru.twistofthemyth.elements.ClickableElement;
import ru.twistofthemyth.page.PageBase;
import ru.twistofthemyth.page.contributions.ContributionPage;
import ru.twistofthemyth.service.DriverHolder;

public class Deposits extends PageBase {
    public Deposits(@NotNull DriverHolder driver) {
        super(driver);
    }

    @Page
    public NavBar navBar;

    @WrappedElement(name = "Калькулятор доходности", essential = true)
    @FindBy(xpath = "//div[@class='nav__item-sub-nav']//a[contains(text(),'Калькулятор доходности')]")
    public ClickableElement calculator;

    //other pages and elements

    @Step("Перейти к калькулятору доходности")
    public ContributionPage openCalculator() {
        calculator.click();
        return new ContributionPage(driver);
    }

}
