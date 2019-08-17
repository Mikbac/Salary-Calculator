/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.facade.impl.salary;

import org.springframework.stereotype.Service;
import pl.MikBac.salaryApp.model.CountryModel;

import java.math.BigDecimal;

@Service
public class Salary {

    private SalaryStrategy strategy;

    public void setStrategy(SalaryStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal getExchangeRate(String countryCode) {
        return strategy.getExchangeRate(countryCode);
    }

    public BigDecimal calculateSalary(CountryModel countryModel, String valueFromClient) {
        return strategy.calculateSalary(countryModel, valueFromClient);
    }
}
