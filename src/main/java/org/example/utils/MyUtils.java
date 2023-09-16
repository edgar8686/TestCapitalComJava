package org.example.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    public static List<String[]> readCSVFile(String filePath) throws IOException, CsvException {
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
