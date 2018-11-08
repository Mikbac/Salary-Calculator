import org.junit.jupiter.api.Test;

public class ExchangeRateTest {


    @Test
    public void getExchangeRateTest1(){
        ExchangeRate test = new ExchangeRate();
        System.out.println(test.getExchangeRate("GBP"));
        System.out.println(test.getExchangeRate("EUR"));
        System.out.println(test.getExchangeRate("PLN"));
    }

}
