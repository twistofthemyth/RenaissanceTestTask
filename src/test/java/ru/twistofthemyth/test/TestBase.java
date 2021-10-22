package ru.twistofthemyth.test;

import org.jetbrains.annotations.Nullable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.twistofthemyth.page.home.HomePage;
import ru.twistofthemyth.service.DriverHolder;

import java.io.IOException;

/**
 * Базовый класс для всех классов, содержащих тесты
 */
public class TestBase {

    @Nullable
    protected DriverHolder driver;
    @Nullable
    protected HomePage startPage;

    @BeforeMethod(description = "Инициализация вебдрайвера")
    public void init() throws IOException {
        driver = DriverHolder.createChromeDesktop();
        startPage = new HomePage(driver);
    }

    @AfterMethod(description = "Закрытие вебдрайвера")
    public void tearDown(ITestResult result) {
        assert driver != null;
        if (!result.isSuccess()) {
            driver.saveScreenshot();
        }
        driver.get().quit();
    }

}
