package restApi.salaries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

public class SalaryPl {

    public static BigDecimal getExchangeRate(String countryCode) {

        if (countryCode.equalsIgnoreCase("PLN"))
            return BigDecimal.valueOf(1);

        try {

            String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + countryCode + "/?format=json";


            RestTemplate restTemplate = new RestTemplate();
            ExchangeRate exchangeRate = restTemplate.getForObject(url, ExchangeRate.class);
            BigDecimal mid = exchangeRate.getRates()[0].getMid();

            return mid;

        } catch (Exception e) {

            return BigDecimal.valueOf(0);

        }


    }
//TODO Brak obsługi błędów oraz walidacji danych wejściowych. Metoda SalaryPl::getExchangeRate zwraca zero w przypadku wyjątku. To powoduje ukrycie ew. wyjątków i błędne obliczenia.


    public static BigDecimal getPlnSalary(BigDecimal valueFromClient, BigDecimal fixedCosts, BigDecimal tax, String currencyCode) {

        BigDecimal baseValue = (valueFromClient.multiply(BigDecimal.valueOf(22))).subtract(fixedCosts);
        BigDecimal salary = baseValue.subtract(baseValue.multiply(tax.divide(BigDecimal.valueOf(100))));

        BigDecimal exchangePLN = getExchangeRate(currencyCode);
        BigDecimal salaryPLN = exchangePLN.multiply(salary);

        return salaryPLN.setScale(2, RoundingMode.CEILING);

    }


}
