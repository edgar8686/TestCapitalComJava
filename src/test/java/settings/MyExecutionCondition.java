package settings;

import com.opencsv.exceptions.CsvException;
import org.example.utils.MyUtils;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.opentest4j.TestAbortedException;

import java.io.IOException;
import java.util.List;

public class MyExecutionCondition implements ExecutionCondition {
    private String parameter1;
    private String parameter2;

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

        String testName = context.getDisplayName();
        System.out.println("condition = " + testName);

        try {
            String filePath = "C:\\Users\\edgar\\Selenium_project\\src\\test\\resources\\Precondition.csv";
            List<String[]> csvData = MyUtils.readCSVFile(filePath);

            for (String[] row : csvData) {
                // Здесь вы можете использовать параметры из CSV файла
                parameter1 = row[0]; // Первый столбец
                parameter2 = row[1]; // Второй столбец

                // Ваш код, использующий параметры
                System.out.println("Parameter 1: " + parameter1);
                System.out.println("Parameter 2: " + parameter2);

            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }


        if (parameter1.equalsIgnoreCase("en") && parameter2.equalsIgnoreCase("gb")) {
            if (testName.equalsIgnoreCase("TC_11-02-07_05 (UnReg)")) {
                throw new TestAbortedException("Тест был пропущен: " + testName);
            }
        }

        // В остальных случаях, выполняем тест
        return ConditionEvaluationResult.enabled("Тест был разрешен: " + testName);
    }

}
