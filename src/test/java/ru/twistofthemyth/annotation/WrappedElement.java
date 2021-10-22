package ru.twistofthemyth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, указывающая что поле является веб-элементом
 * @see ru.twistofthemyth.service.PageInitializer
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface WrappedElement {
    /**
     * Имя веб-элемента
     */
    String name() default "";
    /**
     * Указание на то, что должен ли вебдрайвер ожидать загрузки элемента
     */
    boolean essential() default false;
}
