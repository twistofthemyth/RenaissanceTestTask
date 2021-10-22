package ru.twistofthemyth.elements;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import ru.twistofthemyth.service.DriverHolder;

/**
 * Оболочка над WebElement для селектов
 */
public class SelectElement extends ClickableElement {

    String optionTemplate = "//option[text()='%s']";

    public SelectElement(@NotNull DriverHolder driver, @NotNull By locator, @NotNull String name) {
        super(driver, locator, name);
    }

    @Step("В поле выбора выбрать значение \"{value}\"")
    public void select(String value) {
        actionClick();
        driver.get().findElement(By.xpath(this + String.format(optionTemplate, value))).click();
    }

}
