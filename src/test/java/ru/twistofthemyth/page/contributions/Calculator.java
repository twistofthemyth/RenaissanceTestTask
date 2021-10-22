package ru.twistofthemyth.page.contributions;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.support.FindBy;
import ru.twistofthemyth.annotation.WrappedElement;
import ru.twistofthemyth.elements.ClickableElement;
import ru.twistofthemyth.elements.SliderElement;
import ru.twistofthemyth.elements.TextElement;
import ru.twistofthemyth.page.PageBase;
import ru.twistofthemyth.service.DriverHolder;

public class Calculator extends PageBase {
    public Calculator(@NotNull DriverHolder driver) {
        super(driver);
    }

    @WrappedElement(name = "В отделении банка", essential = true)
    @FindBy(xpath = "//div[@class='internet-bank']/div/div[1]")
    public ClickableElement bankCheckBox;

    @WrappedElement(name = "В интернет-банке", essential = true)
    @FindBy(xpath = "//div[@class='internet-bank']/div/div[2]")
    public ClickableElement internetBankCheckBox;

    @WrappedElement(name = "Сумма вклада", essential = true)
    @FindBy(xpath = "//div[@data-property=\"amount\"]//input")
    public TextElement amount;

    @WrappedElement(name = "На срок (ползунок)", essential = true)
    @FindBy(xpath = "//div[@data-property='period']//div[contains(@class, 'calculator__slide-row')]")
    public SliderElement periodSlider;

    //other pages and elements

    @Step("Заполнить калькулятор доходности произвольными значениями")
    public Calculator performSomeActions() {
        bankCheckBox.getWrappedElement().click();
        amount.fill("2500000");
        periodSlider.slide(20, 200);
        driver.saveScreenshot();
        return this;
    }
}
