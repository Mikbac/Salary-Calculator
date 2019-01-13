import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import restApi.salaries.SalaryPl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetPLnSalaryPlTest {


    @Test
    @DisplayName("return getPlnSalary when values are correct")
    void getExchangeRateWhenCountryCodeIsCorrect() {
        assertEquals(new BigDecimal(-972.00).setScale(2, RoundingMode.CEILING), SalaryPl.getPlnSalary(new BigDecimal(0), new BigDecimal(1200), new BigDecimal(19), "PLN"));
    }

}
