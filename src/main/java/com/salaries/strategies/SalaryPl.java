package com.salaries.strategies;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.entities.Country;
import com.repositories.CountryRepository;
import com.salaries.SalaryStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.salaries.nbpModel.ExchangeRate;

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

    public BigDecimal calculateSalary(Country country, String valueFromClient) {

        BigDecimal valueOfMoney = new BigDecimal(valueFromClient);

        BigDecimal fixedCosts = country.getFixedCosts();
        BigDecimal tax = country.getTax();
        String currencyCode = country.getCurrencyCode();

        BigDecimal baseValue = (valueOfMoney.multiply(BigDecimal.valueOf(22))).subtract(fixedCosts);
        BigDecimal salary = baseValue.subtract(baseValue.multiply(tax.divide(BigDecimal.valueOf(100))));

        BigDecimal exchangePLN = getExchangeRate(currencyCode);
        BigDecimal salaryPLN = exchangePLN.multiply(salary);
        return salaryPLN.setScale(2, RoundingMode.CEILING);

    }


}
