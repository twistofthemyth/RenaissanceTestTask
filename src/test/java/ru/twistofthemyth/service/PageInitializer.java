package ru.twistofthemyth.service;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.twistofthemyth.annotation.Page;
import ru.twistofthemyth.annotation.WrappedElement;
import ru.twistofthemyth.page.PageBase;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Инициализатор страниц
 */
public class PageInitializer {

    public static <T> void initElements(@NotNull DriverHolder driver, @NotNull T page) {
        List<Field> fields = Arrays.stream(page.getClass().getFields()).filter(PageInitializer::isApplicable).collect(Collectors.toList());
        for (Field field : fields) {
            if (field.getAnnotation(FindBy.class) != null && field.getAnnotation(WrappedElement.class) != null) {
                setWrappedElement(driver, field, page);
                if (field.getAnnotation(WrappedElement.class).essential()) {
                    loadWrappedElement(driver, field);
                }
            } else {
                if (field.getAnnotation(Page.class) != null) {
                    setPage(driver, field, page);
                }
            }
        }
    }

    /**
     * Инициализация веб-элемента
     * @see WrappedElement
     */
    private static <T> void setWrappedElement(@NotNull DriverHolder driver, @NotNull Field field, @NotNull T page) {
        String xpath = field.getAnnotation(FindBy.class).xpath();
        String name = field.getAnnotation(FindBy.class).name();
        try {
            field.set(page, field.getType().getConstructor(DriverHolder.class, By.class, String.class).newInstance(driver, By.xpath(xpath), name));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException ignored) {
        }
    }

    /**
     * Инициализация страницы и всех ее полей
     * @see Page
     * @see WrappedElement
     */
    private static <T> void setPage(@NotNull DriverHolder driver, @NotNull Field field, @NotNull T page) {
        try {
            Object nestedPage = field.getType().getConstructor(DriverHolder.class).newInstance(driver);
            field.set(page, nestedPage);
            initElements(driver, nestedPage);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException ignored) {
        }
    }

    /**
     * Ожидание появления веб-элементов
     * @see WrappedElement
     */
    //TODO Вынести длительность ожидания в application.properies
    private static <T> void loadWrappedElement(@NotNull DriverHolder driver, Field field) {
        String xpath = field.getAnnotation(FindBy.class).xpath();
        WebDriverWait wait = new WebDriverWait(driver.get(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    private static boolean isApplicable(Field field) {
        return PageBase.class.isAssignableFrom(field.getType()) ||
                ru.twistofthemyth.elements.WrappedElement.class.isAssignableFrom(field.getType());
    }
}
