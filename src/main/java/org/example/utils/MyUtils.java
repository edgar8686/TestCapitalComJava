package org.example.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.FileUtils;
import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getDriver;

public class MyUtils {
    public static List<String[]> readCSVFile(String filePath) {
        List<String[]> dataList = new ArrayList<>();
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Прочитать и проигнорировать первую строку (заголовки)
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] dataArray = line.split(cvsSplitBy);
                dataList.add(dataArray);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public static File makeScreenshot(WebDriver driver, String filename) {
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./target/" + filename);
        try {
            FileUtils.copyFile(temp, destination);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return destination;
    }

    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    public static void getLogs(WebDriver driver) {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
       /* Assertions.assertEquals(0,allLogRows.size());
        Assertions.assertTrue(allLogRows.isEmpty());*/
        if (allLogRows.size() > 0) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });

        }
    }
}
