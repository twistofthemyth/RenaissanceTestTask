package ru.twistofthemyth.elements;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.twistofthemyth.service.DriverHolder;

/**
 * Оболочка над WebElement для кликабельных элементов
 */
public class ClickableElement extends WrappedElement {

    public ClickableElement(@NotNull DriverHolder driver, @NotNull By locator, @NotNull String name) {
        super(driver, locator, name);
    }

    @Override
    public @NotNull WebElement getWrappedElement() {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.get().findElement(locator);
    }

    @Step("Кликнуть на элемент")
    public void click() {
        moveToElement();
        driver.get().findElement(locator).click();
    }

    @Step("Кликнуть на элемент")
    public void actionClick() {
        moveToElement();
        actions.click(driver.get().findElement(locator)).build().perform();
    }
}
