/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.service;

import pl.MikBac.salaryApp.model.CountryModel;

import java.math.BigDecimal;

public interface SalaryService {

    BigDecimal getSalaryPLN(final CountryModel country, final String valueFromClient);

}
