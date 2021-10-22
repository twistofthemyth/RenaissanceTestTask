package ru.twistofthemyth.page;

import org.jetbrains.annotations.NotNull;
import ru.twistofthemyth.service.DriverHolder;
import ru.twistofthemyth.service.PageInitializer;

/**
 * Родительский класс для всех страниц
 * Страницы могут содержать By, WebElement, WrappedElement и Page поля
 *
 * По классическому паттерну PageObject действия со страницам хранятся тут же и всегда возвращают экземпляр
 * какой-нибудь страницы (fluent chain of invocations)
 *
 * @see ru.twistofthemyth.annotation.Page
 * @see ru.twistofthemyth.annotation.WrappedElement
 */
public class PageBase {

    @NotNull
    protected DriverHolder driver;

    public PageBase(@NotNull DriverHolder driver) {
        this.driver = driver;
        PageInitializer.initElements(driver, this);
    }
}
