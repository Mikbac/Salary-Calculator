package pl.mikbac.salaryapp.spring.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mikbac.salaryapp.spring.property.NbpProperties;
import pl.mikbac.salaryapp.spring.repository.impl.CurrencyRepositoryImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

/**
 * Created by MikBac on 2018
 */

@RunWith(SpringRunner.class)
@ActiveProfiles("development")
public class CurrencyRepositoryTest {

    @InjectMocks
    private final CurrencyRepository currencyRepository = new CurrencyRepositoryImpl();

    @Mock
    private NbpProperties nbpProperties;

    @Before
    public void init() {
        when(nbpProperties.getAddress()).thenReturn("http://api.nbp.pl");
    }

    @Test
    @DisplayName("return getExchangeRate when countryCode is correct value")
    public void getExchangeRateWhenCountryCodeIsCorrect() {
        assertNotEquals(new BigDecimal(0), currencyRepository.getExchangeRate("EUR").get());
        assertNotEquals(new BigDecimal(0), currencyRepository.getExchangeRate("eur").get());
        assertNotEquals(new BigDecimal(0), currencyRepository.getExchangeRate("GBP").get());
        assertNotEquals(new BigDecimal(0), currencyRepository.getExchangeRate("gbp").get());
    }

    @Test
    @DisplayName("return getExchangeRate when countryCode is PLN")
    public void getExchangeRateWhenCountryCodeIsPLN() {
        assertEquals(new BigDecimal(1), currencyRepository.getExchangeRate("PLN").get());
        assertEquals(new BigDecimal(1), currencyRepository.getExchangeRate("pln").get());
    }

}
