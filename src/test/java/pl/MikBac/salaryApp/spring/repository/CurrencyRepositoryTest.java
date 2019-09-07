/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.MikBac.salaryApp.spring.repository.impl.CurrencyRepositoryImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CurrencyRepositoryTest {

    @Test
    @DisplayName("return getExchangeRate when countryCode is correct value")
    public void getExchangeRateWhenCountryCodeIsCorrect() {
        CurrencyRepository currencyRepository = new CurrencyRepositoryImpl();
        assertNotEquals(new BigDecimal(0), currencyRepository.getExchangeRate("EUR").get());
        assertNotEquals(new BigDecimal(0), currencyRepository.getExchangeRate("eur").get());
        assertNotEquals(new BigDecimal(0), currencyRepository.getExchangeRate("GBP").get());
        assertNotEquals(new BigDecimal(0), currencyRepository.getExchangeRate("gbp").get());
    }

    @Test
    @DisplayName("return getExchangeRate when countryCode is PLN")
    public void getExchangeRateWhenCountryCodeIsPLN() {
        CurrencyRepository currencyRepository = new CurrencyRepositoryImpl();
        assertEquals(new BigDecimal(1), currencyRepository.getExchangeRate("PLN").get());
        assertEquals(new BigDecimal(1), currencyRepository.getExchangeRate("pln").get());
    }

}
