package com.salaries.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.salaries.SalaryStrategy;
import org.springframework.web.client.RestTemplate;
import com.salaries.nbpModel.ExchangeRate;

public class SalaryPl implements SalaryStrategy {

    public BigDecimal getExchangeRate(String countryCode) {

        if (countryCode.equalsIgnoreCase("PLN"))
            return BigDecimal.valueOf(1);

        String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + countryCode + "/?format=json";


        RestTemplate restTemplate = new RestTemplate();
        ExchangeRate exchangeRate = restTemplate.getForObject(url, ExchangeRate.class);
        BigDecimal mid = exchangeRate.getRates()[0].getMid();

        return mid;

    }

    public BigDecimal calculateSalary(BigDecimal valueFromClient, BigDecimal fixedCosts, BigDecimal tax, String currencyCode) {

        BigDecimal baseValue = (valueFromClient.multiply(BigDecimal.valueOf(22))).subtract(fixedCosts);
        BigDecimal salary = baseValue.subtract(baseValue.multiply(tax.divide(BigDecimal.valueOf(100))));

        BigDecimal exchangePLN = getExchangeRate(currencyCode);
        BigDecimal salaryPLN = exchangePLN.multiply(salary);

        return salaryPLN.setScale(2, RoundingMode.CEILING);

    }


}
