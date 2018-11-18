import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restApi.salaries.SalaryPl;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExchangeRateTest {

    @Test
    @DisplayName("return getExchangeRate when countryCode is wrong value")
    void getExchangeRateWhenCountryCodeIsWrong() {
        assertEquals( new BigDecimal(0), SalaryPl.getExchangeRate("EU1R1"));
        assertEquals( new BigDecimal(0), SalaryPl.getExchangeRate("pug"));
        assertEquals( new BigDecimal(0), SalaryPl.getExchangeRate("eu12"));
        assertEquals( new BigDecimal(0), SalaryPl.getExchangeRate("123"));
        assertEquals( new BigDecimal(0), SalaryPl.getExchangeRate(""));
    }

    @Test
    @DisplayName("return getExchangeRate when countryCode is correct value")
    void getExchangeRateWhenCountryCodeIsCorrect() {
        assertNotEquals( new BigDecimal(0), SalaryPl.getExchangeRate("EUR"));
        assertNotEquals( new BigDecimal(0), SalaryPl.getExchangeRate("eur"));
        assertNotEquals( new BigDecimal(0), SalaryPl.getExchangeRate("GBP"));
        assertNotEquals( new BigDecimal(0), SalaryPl.getExchangeRate("gbp"));
    }


    @Test
    @DisplayName("return getExchangeRate when countryCode is PLN")
    void getExchangeRateWhenCountryCodeIsPLN() {
        assertEquals( new BigDecimal(1), SalaryPl.getExchangeRate("PLN"));
        assertEquals( new BigDecimal(1), SalaryPl.getExchangeRate("pln"));
    }

}
