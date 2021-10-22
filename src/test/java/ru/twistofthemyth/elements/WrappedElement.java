package ru.twistofthemyth.elements;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.twistofthemyth.service.DriverHolder;

/**
 * Родительский класс для всех оболочек над WebElement
 * Хранит ссыдку на локатор (поддерживает только XPath) и на экземпляр драйвера
 * Работает с @FindBy если указать @WrappedElement
 */
public class WrappedElement implements WrapsElement {

    @NotNull
    protected final By locator;
    @NotNull
    protected DriverHolder driver;
    @NotNull
    protected WebDriverWait wait;
    @NotNull
    protected Actions actions;
    @NotNull
    protected final String name;

    public WrappedElement(@NotNull DriverHolder driver, @NotNull By locator, @NotNull String name) {
        this.driver = driver;
        this.locator = locator;
        this.name = name;
        wait = new WebDriverWait(driver.get(), 10);
        actions = new Actions(driver.get());
    }

    @Override
    @NotNull
    public WebElement getWrappedElement() {
        return driver.get().findElement(locator);
    }

    public void moveToElement() {
        actions.moveToElement(driver.get().findElement(locator)).build().perform();
    }

    @Override
    public @NotNull String toString() {
        return locator.toString().substring(10);
    }
}
