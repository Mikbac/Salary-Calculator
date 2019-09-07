/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.repository;

import java.math.BigDecimal;
import java.util.Optional;

public interface CurrencyRepository {

    Optional<BigDecimal> getExchangeRate(final String currencyCode);

}
