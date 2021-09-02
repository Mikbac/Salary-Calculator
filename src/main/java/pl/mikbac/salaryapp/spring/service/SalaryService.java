package pl.mikbac.salaryapp.spring.service;

import pl.mikbac.salaryapp.model.CountryModel;

import java.math.BigDecimal;

/**
 * Created by MikBac on 07.09.2019
 */

public interface SalaryService {

    /**
     * Calculate salary.
     *
     * @param country         to calculate salary.
     * @param valueFromClient salary from user.
     * @return salary {@link BigDecimal}.
     */
    BigDecimal getSalaryPLN(final CountryModel country, final String valueFromClient);

}
