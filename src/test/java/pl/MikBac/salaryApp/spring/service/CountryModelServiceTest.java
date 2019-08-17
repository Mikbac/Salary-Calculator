/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.MikBac.salaryApp.spring.facade.CountryFacade;
import pl.MikBac.salaryApp.spring.facade.impl.salary.Salary;
import pl.MikBac.salaryApp.spring.facade.impl.salary.strategies.SalaryPl;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CountryModelServiceTest {

    @MockBean
    CountryFacade countryFacade;

    @Test
    public void getExchangeRateWhenCountryCodeIsCorrect() throws Exception {
        Salary salary = new Salary();
        countryFacade.setStrategy(salary, new SalaryPl());
        BigDecimal ans = countryFacade.calculateSalary(salary, "PL", "123");
        BigDecimal wrong = new BigDecimal(0);
        org.junit.Assert.assertNotSame(wrong, ans);
    }
}