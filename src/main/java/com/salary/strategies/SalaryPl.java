package com.salary.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.model.CountryModel;
import com.salary.SalaryStrategy;
import org.springframework.web.client.RestTemplate;
import com.salary.nbpModel.ExchangeRate;

public class SalaryPl implements SalaryStrategy {


    public SalaryPl() {
    }

    public BigDecimal getExchangeRate(String currencyCode) {

        if (currencyCode.equalsIgnoreCase("PLN"))
            return BigDecimal.valueOf(1);

        String url = "http://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode + "/?format=json";


        RestTemplate restTemplate = new RestTemplate();
        ExchangeRate exchangeRate = restTemplate.getForObject(url, ExchangeRate.class);
        BigDecimal mid = exchangeRate.getRates()[0].getMid();

        return mid;

    }

    public BigDecimal calculateSalary(CountryModel countryModel, String valueFromClient) {

        BigDecimal valueOfMoney = new BigDecimal(valueFromClient);

        BigDecimal fixedCosts = countryModel.getFixedCosts();
        BigDecimal tax = countryModel.getTax();
        String currencyCode = countryModel.getCurrencyCode();

        BigDecimal baseValue = (valueOfMoney.multiply(BigDecimal.valueOf(22))).subtract(fixedCosts);
        BigDecimal salary = baseValue.subtract(baseValue.multiply(tax.divide(BigDecimal.valueOf(100))));

        BigDecimal exchangePLN = getExchangeRate(currencyCode);
        BigDecimal salaryPLN = exchangePLN.multiply(salary);
        return salaryPLN.setScale(2, RoundingMode.CEILING);

    }


}
