package pl.mikbac.salary_app.spring.facade;

import java.math.BigDecimal;

/**
 * Created by MikBac on 25.07.2019
 */

public interface SalaryFacade {

    /**
     * Calculate salary.
     *
     * @param countryCode     code of country.
     * @param valueFromClient salary from user.
     * @return salary {@link BigDecimal}.
     */
    BigDecimal calculateSalary(String countryCode, String valueFromClient);
}
