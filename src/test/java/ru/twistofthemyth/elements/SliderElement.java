package ru.twistofthemyth.elements;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import ru.twistofthemyth.service.DriverHolder;

/**
 * Оболочка над WebElement для слайдеров
 */
public class SliderElement extends ClickableElement {

    private final By slidePoint = By.xpath(this + "//div");
    private final By slideRange = By.xpath(this + "//span");

    public SliderElement(@NotNull DriverHolder driver, @NotNull By locator, @NotNull String name) {
        super(driver, locator, name);
    }

    /**
     * @param position - до какой позиции нужно сдвинуть ползунов
     * @param precision - с какой точностью ползнунок следует двигать
     */
    //TODO Исправить возможность вечного цикла
    @Step("Передвинуть ползунок на значение \"{position}\"")
    public void slide(@NotNull int position, @NotNull int precision) {
        if (getCurrentPosition() > position) {
            slideDown(position, precision);
        } else if (getCurrentPosition() < position) {
            slideUp(position, precision);
        }
    }

    //TODO Придумать как объединить с slideDown
    private void slideUp(@NotNull int position, @NotNull int precision) {
        int movement = precision;
        int lastPosition;
        while (getCurrentPosition() < position) {
            lastPosition = getCurrentPosition();
            actions.clickAndHold(getWrappedElement().findElement(slidePoint)).moveByOffset(movement, 0).build().perform();
            if (getCurrentPosition() == lastPosition) {
                movement *= 2;
            }
        }
    }

    private void slideDown(@NotNull int position, @NotNull int precision) {
        int movement = precision;
        int lastPosition;
        while (getCurrentPosition() > position) {
            lastPosition = getCurrentPosition();
            actions.clickAndHold(getWrappedElement().findElement(slidePoint)).moveByOffset(-movement, 0).build().perform();
            if (getCurrentPosition() == lastPosition) {
                movement *= 2;
            }
        }
    }

    /**
     * Получить текущую позицию ползунка
     */
    private int getCurrentPosition() {
        String rawValue = getWrappedElement().findElement(slideRange).getAttribute("style");
        return Integer.parseInt(rawValue.substring(6, rawValue.length() - 2));
    }
}
