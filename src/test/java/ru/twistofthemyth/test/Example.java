package ru.twistofthemyth.test;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

@Test
public class Example extends TestBase {

    @Test(suiteName = "Тестовое задание", description = "Тест 1")
    @Description("Реализация первого теста")
    public void test1() {
        startPage.navBar.openDeposits().openCalculator().calculator.performSomeActions();
    }

    @Test(suiteName = "Тестовое задание", description = "Тест 2")
    @Description("Реализация второго теста")
    public void test2() {
        startPage.navBar.openCards().choseCard().choosePracticCard().performSomeActions();
    }

}
