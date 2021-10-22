package ru.twistofthemyth.elements;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import ru.twistofthemyth.service.DriverHolder;

/**
 * Оболочка над WebElement для текстовых элементов
 */
public class TextElement extends ClickableElement {

    public TextElement(@NotNull DriverHolder driver, @NotNull By locator, @NotNull String name) {
        super(driver, locator, name);
    }

    @Step("Заполнить текстовое поле значением \"{text}\"")
    public void fill(@NotNull String text) {
        getWrappedElement().sendKeys(text);
    }
}
