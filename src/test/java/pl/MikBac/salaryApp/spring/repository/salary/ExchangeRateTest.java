/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.repository.salary;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.MikBac.salaryApp.spring.repository.salary.impl.SalaryRepositoryImpl;
import pl.MikBac.salaryApp.spring.repository.salary.impl.strategies.SalaryPl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExchangeRateTest {

    @Test
    @DisplayName("return getExchangeRate when countryCode is correct value")
    public void getExchangeRateWhenCountryCodeIsCorrect() {
        SalaryRepositoryImpl salaryImpl = new SalaryRepositoryImpl();
        salaryImpl.setStrategy(new SalaryPl());
        assertNotEquals(new BigDecimal(0), salaryImpl.getExchangeRate("EUR"));
        assertNotEquals(new BigDecimal(0), salaryImpl.getExchangeRate("eur"));
        assertNotEquals(new BigDecimal(0), salaryImpl.getExchangeRate("GBP"));
        assertNotEquals(new BigDecimal(0), salaryImpl.getExchangeRate("gbp"));
    }

    @Test
    @DisplayName("return getExchangeRate when countryCode is PLN")
    public void getExchangeRateWhenCountryCodeIsPLN() {
        SalaryRepositoryImpl salaryImpl = new SalaryRepositoryImpl();
        salaryImpl.setStrategy(new SalaryPl());
        assertEquals(new BigDecimal(1), salaryImpl.getExchangeRate("PLN"));
        assertEquals(new BigDecimal(1), salaryImpl.getExchangeRate("pln"));
    }

}
