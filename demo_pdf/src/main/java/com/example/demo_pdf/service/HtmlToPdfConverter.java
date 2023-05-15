package com.example.demo_pdf.service;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

public class HtmlToPdfConverter {
    @Value("${customreport.controller.chromedriverpath}")
    private static String chromeDriverPath;
    public static void convertHtmlToPdf(String htmlFilePath , String pdfFilePath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usuage");

        RemoteWebDriver driver = new ChromeDriver(options);
//        String url = new File(htmlFilePath).toURI().toString();

        driver.get("http://localhost:8080/barcharts");
        driver.executeScript("window.print();");
        driver.quit();
    }
}
