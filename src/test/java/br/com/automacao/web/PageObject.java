package br.com.automacao.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        if (browser != null) {
            browser = browser;
        } else {
            browser = new ChromeDriver();
        }
    }

    public void fechar() {
        browser.quit();
    }
}
