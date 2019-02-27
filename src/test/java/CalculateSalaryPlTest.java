import com.salaries.Salary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.salaries.salary.SalaryPl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateSalaryPlTest {


    @Test
    @DisplayName("return calculateSalary when values are correct")
    void getExchangeRateWhenCountryCodeIsCorrect() {

        Salary salary = new Salary();
        salary.setStrategy(new SalaryPl());

        assertEquals(new BigDecimal(-972.00).setScale(2, RoundingMode.CEILING), salary.calculateSalary(new BigDecimal(0), new BigDecimal(1200), new BigDecimal(19), "PLN"));
    }

}
