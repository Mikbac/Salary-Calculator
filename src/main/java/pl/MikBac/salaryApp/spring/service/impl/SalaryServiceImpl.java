/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.MikBac.salaryApp.model.CountryModel;
import pl.MikBac.salaryApp.spring.repository.salary.SalaryRepository;
import pl.MikBac.salaryApp.spring.repository.salary.impl.strategies.SalaryPl;
import pl.MikBac.salaryApp.spring.service.SalaryService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Resource
    private SalaryRepository salaryRepository;

    @Override
    public BigDecimal getSalaryPLN(final CountryModel country, final String valueFromClient) {
        salaryRepository.setStrategy(new SalaryPl());
        return salaryRepository.calculateSalary(country, valueFromClient);
    }

}
