/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.repository.salary.impl;

import org.springframework.stereotype.Repository;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.repository.salary.SalaryRepository;
import pl.MikBac.salaryApp.spring.repository.salary.SalaryStrategy;

import java.math.BigDecimal;

@Repository
public class SalaryRepositoryImpl implements SalaryRepository {

    private SalaryStrategy strategy;

    public void setStrategy(final SalaryStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal getExchangeRate(final String countryCode) {
        return strategy.getExchangeRate(countryCode);
    }

    public BigDecimal calculateSalary(final CountryModel countryModel, final String valueFromClient) {
        return strategy.calculateSalary(countryModel, valueFromClient);
    }
}
