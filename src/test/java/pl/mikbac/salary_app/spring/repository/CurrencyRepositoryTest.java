package pl.mikbac.salary_app.spring.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import pl.mikbac.salary_app.model.ExchangeRate;
import pl.mikbac.salary_app.model.Rate;
import pl.mikbac.salary_app.spring.property.NbpProperties;
import pl.mikbac.salary_app.spring.repository.impl.CurrencyRepositoryImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

/**
 * Created by MikBac on 2018
 */

@RunWith(SpringRunner.class)
@ActiveProfiles("development")
public class CurrencyRepositoryTest {

    private static final String HTTP_API_NBP_PL = "http://api.nbp.pl";

    @InjectMocks
    private final CurrencyRepository currencyRepository = new CurrencyRepositoryImpl();

    @Mock
    private NbpProperties nbpProperties;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void init() {
        when(nbpProperties.getAddress()).thenReturn(HTTP_API_NBP_PL);

        Rate rate = new Rate();
        rate.setMid(new BigDecimal("9.99"));
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setRates(new Rate[]{rate});
        when(restTemplate.getForObject(contains(HTTP_API_NBP_PL), notNull())).thenReturn(exchangeRate);
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
