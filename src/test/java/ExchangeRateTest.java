import com.salaries.Salary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.salaries.salary.SalaryPl;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExchangeRateTest {

    @Test
    @DisplayName("return getExchangeRate when countryCode is correct value")
    void getExchangeRateWhenCountryCodeIsCorrect() {

        Salary salary = new Salary();
        salary.setStrategy(new SalaryPl());

        assertNotEquals(new BigDecimal(0), salary.getExchangeRate("EUR"));
        assertNotEquals(new BigDecimal(0), salary.getExchangeRate("eur"));
        assertNotEquals(new BigDecimal(0), salary.getExchangeRate("GBP"));
        assertNotEquals(new BigDecimal(0), salary.getExchangeRate("gbp"));
    }


    @Test
    @DisplayName("return getExchangeRate when countryCode is PLN")
    void getExchangeRateWhenCountryCodeIsPLN() {

        Salary salary = new Salary();
        salary.setStrategy(new SalaryPl());

        assertEquals(new BigDecimal(1), salary.getExchangeRate("PLN"));
        assertEquals(new BigDecimal(1), salary.getExchangeRate("pln"));
    }

}
