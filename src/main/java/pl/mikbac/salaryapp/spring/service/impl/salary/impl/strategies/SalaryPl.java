package pl.mikbac.salaryapp.spring.service.impl.salary.impl.strategies;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.mikbac.salaryapp.exception.InvalidSalaryFromClientException;
import pl.mikbac.salaryapp.model.CountryModel;
import pl.mikbac.salaryapp.spring.service.impl.salary.SalaryStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by MikBac on 2018
 */

@Log4j2
@Service
public class SalaryPl implements SalaryStrategy {

    public SalaryPl() {
    }

    public BigDecimal calculateSalary(final BigDecimal exchangeRate, final CountryModel country, final String salaryFromClient) {
        try {
            final BigDecimal valueOfMoney = new BigDecimal(salaryFromClient);
            final BigDecimal fixedCosts = country.getFixedCosts();
            final BigDecimal tax = country.getTax();
            final BigDecimal baseValue = (valueOfMoney.multiply(BigDecimal.valueOf(22))).subtract(fixedCosts);
            final BigDecimal salary = baseValue.subtract(baseValue.multiply(tax.divide(BigDecimal.valueOf(100))));
            final BigDecimal salaryPLN = exchangeRate.multiply(salary);
            return salaryPLN.setScale(2, RoundingMode.CEILING);
        } catch (NumberFormatException e) {
            log.error("Invalid value from client for: {}", () -> salaryFromClient);
            throw new InvalidSalaryFromClientException(salaryFromClient);
        }
    }

}
