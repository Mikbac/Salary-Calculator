package pl.MikBac.salaryApp.salary;

import pl.MikBac.salaryApp.model.CountryModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

@Service
public class Salary {

    private SalaryStrategy strategy;

    public void setStrategy(SalaryStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal getExchangeRate(String countryCode){
       return strategy.getExchangeRate(countryCode);
    }

    public BigDecimal calculateSalary(CountryModel countryModel, String valueFromClient){
        return strategy.calculateSalary(countryModel, valueFromClient);
    }
}
