/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service.impl.salary.impl.strategies;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.MikBac.salaryApp.exception.InvalidSalaryFromClientException;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.service.impl.salary.SalaryStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Log4j2
@Service
public class SalaryPl implements SalaryStrategy {

    public SalaryPl() {
    }

    public BigDecimal calculateSalary(final BigDecimal exchangeRate, final CountryModel country, final String salaryFromClient) {
        try {
            BigDecimal valueOfMoney = new BigDecimal(salaryFromClient);
            BigDecimal fixedCosts = country.getFixedCosts();
            BigDecimal tax = country.getTax();
            BigDecimal baseValue = (valueOfMoney.multiply(BigDecimal.valueOf(22))).subtract(fixedCosts);
            BigDecimal salary = baseValue.subtract(baseValue.multiply(tax.divide(BigDecimal.valueOf(100))));
            BigDecimal salaryPLN = exchangeRate.multiply(salary);
            return salaryPLN.setScale(2, RoundingMode.CEILING);
        } catch (NumberFormatException e) {
            log.error("Invalid value from client for: {}", () -> salaryFromClient);
            throw new InvalidSalaryFromClientException(salaryFromClient);
        }
    }

}
