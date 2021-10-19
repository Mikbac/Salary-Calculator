package pl.mikbac.salary_app.spring.service.impl.salary.impl.strategies;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.mikbac.salary_app.exception.InvalidSalaryFromClientException;
import pl.mikbac.salary_app.model.CountryModel;
import pl.mikbac.salary_app.spring.service.impl.salary.SalaryStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by MikBac on 2018
 */

@Log4j2
@Service
public class SalaryPLN implements SalaryStrategy {

    public BigDecimal calculateSalary(final BigDecimal exchangeRate,
                                      final CountryModel country,
                                      final String salaryFromClient) {
        try {
            final BigDecimal valueOfMoney = new BigDecimal(salaryFromClient);
            final BigDecimal baseValue = (valueOfMoney.multiply(BigDecimal.valueOf(22))).subtract(country.getFixedCosts());
            final BigDecimal salary = baseValue.subtract(baseValue.multiply(country.getTax().divide(BigDecimal.valueOf(100), RoundingMode.CEILING)));
            final BigDecimal salaryPLN = exchangeRate.multiply(salary);
            return salaryPLN.setScale(2, RoundingMode.CEILING);
        } catch (NumberFormatException e) {
            throw new InvalidSalaryFromClientException(salaryFromClient);
        }
    }

}
