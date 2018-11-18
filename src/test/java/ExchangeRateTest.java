import org.junit.jupiter.api.DisplayName;
import restApi.exchangeRateFromApi.ExchangeRate;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExchangeRateTest {

    @Test
    @DisplayName("return getExchangeRate when countryCode is wrong value")
    void getExchangeRateWhenCountryCodeIsWrong() {
        assertEquals(0.0, ExchangeRate.getExchangeRate("EU1R1"));
        assertEquals(0.0, ExchangeRate.getExchangeRate("pug"));
        assertEquals(0.0, ExchangeRate.getExchangeRate("eu12"));
        assertEquals(0.0, ExchangeRate.getExchangeRate("123"));
        assertEquals(0.0, ExchangeRate.getExchangeRate(""));
    }

    @Test
    @DisplayName("return getExchangeRate when countryCode is correct value")
    void getExchangeRateWhenCountryCodeIsCorrect() {
        assertNotEquals(0.0, ExchangeRate.getExchangeRate("EUR"));
        assertNotEquals(0.0, ExchangeRate.getExchangeRate("eur"));
        assertNotEquals(0.0, ExchangeRate.getExchangeRate("GBP"));
        assertNotEquals(0.0, ExchangeRate.getExchangeRate("gbp"));
    }


    @Test
    @DisplayName("return getExchangeRate when countryCode is PLN")
    void getExchangeRateWhenCountryCodeIsPLN() {
        assertEquals(1.0, ExchangeRate.getExchangeRate("PLN"));
        assertEquals(1.0, ExchangeRate.getExchangeRate("pln"));
    }

}
