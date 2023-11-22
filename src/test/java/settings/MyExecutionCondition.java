package settings;


import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyExecutionCondition implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

        String country = context.getDisplayName().substring(4);
        String testName = getTestNameFromAnnotation(context);


        //System.out.println("condition = " + testName);
        //System.out.println("test name = " + country);
        // System.out.println("condition2 = " + country);

        String filePath = "src\\test\\resources\\Precondition.csv";
        // List<String[]> list = MyUtils.readCSVFile(filePath);
        String line;
        String cvsSplitBy = ",";

        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Прочитать и проигнорировать первую строку (заголовки)
            br.readLine();

            // Прочитать данные со второй строки
            if ((line = br.readLine()) != null) {
                String[] dataArray = line.split(cvsSplitBy);
                for (String dataPoint : dataArray) {
                    list2.add(dataPoint);
                }
            }

            // Прочитать данные с третьей строки
            if ((line = br.readLine()) != null) {
                String[] dataArray = line.split(cvsSplitBy);
                for (String dataPoint : dataArray) {
                    list3.add(dataPoint);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (country.equalsIgnoreCase("es, es") && testName.equalsIgnoreCase("TC_11-02-07_07 (UnReg)")) {
            return ConditionEvaluationResult.disabled("Test Skipped: ETF trading not found. For tests on language " + list2.get(0) + " and on Country " + list2.get(1) + " the page Education->ETF trading doesn't exist on production");
        }

        // else if (testName.equalsIgnoreCase("TC_11-02-07_09 (UnReg)")) {
        //    return ConditionEvaluationResult.disabled("Test Skipped: ETF trading not found. For tests on language " + list2.get(0) + " and on Country " + list2.get(1) + " the page Education->ETF trading doesn't exist on production");
        // }
        //}
        return ConditionEvaluationResult.enabled("The parameters are valid for this test: " + testName);
    }

    private String getTestNameFromAnnotation(ExtensionContext context) {
        Name testName = context.getElement()
                .map(element -> element.getAnnotation(Name.class))
                .orElse(null);

        return testName != null ? testName.displayName() : "";
    }
}
