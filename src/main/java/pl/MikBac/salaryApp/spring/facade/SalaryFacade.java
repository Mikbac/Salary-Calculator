/**
 * Created by MikBac on 25.07.2019
 */

package pl.MikBac.salaryApp.spring.facade;

import java.math.BigDecimal;

public interface SalaryFacade {

    /**
     * Calculate salary.
     *
     * @param countryCode     code of country.
     * @param valueFromClient salary from user.
     * @return salary {@link BigDecimal}.
     */
    BigDecimal calculateSalary(final String countryCode, final String valueFromClient);
}
