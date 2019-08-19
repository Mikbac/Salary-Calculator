/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.facade.impl.salary.strategies;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.MikBac.salaryApp.exception.InvalidApiAddressException;
import pl.MikBac.salaryApp.exception.InvalidSalaryFromClientException;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.facade.impl.salary.SalaryStrategy;
import pl.MikBac.salaryApp.spring.facade.impl.salary.nbpModel.ExchangeRate;
import pl.MikBac.salaryApp.spring.facade.impl.salary.strategies.address.Address;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Log4j2
public class SalaryPl implements SalaryStrategy {

    public SalaryPl() {
    }

    private String getUrl(String currencyCode) {
        return Address.NBP.getUrl() + "/api/exchangerates/rates/A/" + currencyCode + "/?format=json";
    }

    public BigDecimal getExchangeRate(String currencyCode) {
        String url = getUrl(currencyCode);
        if (currencyCode.equalsIgnoreCase("PLN")) {
            return BigDecimal.valueOf(1);
        }
        try {
            RestTemplate restTemplate = new RestTemplate();
            ExchangeRate exchangeRate = restTemplate.getForObject(url, ExchangeRate.class);
            BigDecimal mid = exchangeRate.getRates()[0].getMid();
            return mid;
        } catch (HttpClientErrorException e) {
            log.error("Invalid API address for url: {}", () -> url);
            throw new InvalidApiAddressException(url);
        }
    }

    private BigDecimal getBigDecimalFromString(String number) {
        return new BigDecimal(number);
    }

    public BigDecimal calculateSalary(CountryModel countryModel, String salaryFromClient) {
        try {
            BigDecimal valueOfMoney = getBigDecimalFromString(salaryFromClient);
            BigDecimal fixedCosts = countryModel.getFixedCosts();
            BigDecimal tax = countryModel.getTax();
            String currencyCode = countryModel.getCurrencyCode();
            BigDecimal baseValue = (valueOfMoney.multiply(BigDecimal.valueOf(22))).subtract(fixedCosts);
            BigDecimal salary = baseValue.subtract(baseValue.multiply(tax.divide(BigDecimal.valueOf(100))));
            BigDecimal exchangePLN = getExchangeRate(currencyCode);
            BigDecimal salaryPLN = exchangePLN.multiply(salary);
            return salaryPLN.setScale(2, RoundingMode.CEILING);
        } catch (NumberFormatException e) {
            log.error("Invalid value from client for: {}", () -> salaryFromClient);
            throw new InvalidSalaryFromClientException(salaryFromClient);
        }
    }

}
