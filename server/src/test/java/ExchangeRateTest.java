import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExchangeRateTest {



    @Test
    void getExchangeRateTest1(){
        assertEquals(0.0, ExchangeRate.getExchangeRate("EU1R1"));
    }

    @Test
    void getExchangeRateTest2(){
        assertEquals(0.0, ExchangeRate.getExchangeRate("123"));
    }

    @Test
    void getExchangeRateTest3(){
        assertNotEquals(0.0, ExchangeRate.getExchangeRate("EUR"));
    }

    @Test
    void getExchangeRateTest4(){
        assertNotEquals(0.0, ExchangeRate.getExchangeRate("GBP"));
    }

    @Test
    void getExchangeRateTest5(){
        assertNotEquals(0.0, ExchangeRate.getExchangeRate("gbp"));
    }

    @Test
    void getExchangeRateTest6(){
        assertEquals(1.0, ExchangeRate.getExchangeRate("PLN"));
    }

    @Test
    void getExchangeRateTest7(){
        assertEquals(1.0, ExchangeRate.getExchangeRate("pln"));
    }

    @Test
    void getExchangeRateTest8(){
        assertEquals(0.0, ExchangeRate.getExchangeRate(""));
    }

}
