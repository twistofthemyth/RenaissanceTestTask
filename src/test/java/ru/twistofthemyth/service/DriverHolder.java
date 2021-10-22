package ru.twistofthemyth.service;

import io.qameta.allure.Attachment;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Оболочка над вебдрайвером
 * На данный момент умеет только создавать экземпляр ChromeDriver и делать скриншоты
 */
public class DriverHolder {

    @NotNull
    private final WebDriver webDriver;

    private DriverHolder(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

    public WebDriver get() {
        return webDriver;
    }

    public static DriverHolder createChromeDesktop() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\application.properties"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + properties.getProperty("webdriver.binary.path"));

        WebDriver webDriver = new ChromeDriver();
        webDriver.get(properties.getProperty("web.start.url"));
        webDriver.manage().window().maximize();

        return new DriverHolder(webDriver);
    }
}
