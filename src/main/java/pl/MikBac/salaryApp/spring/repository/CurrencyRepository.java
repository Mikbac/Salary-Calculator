/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.repository;

import java.math.BigDecimal;
import java.util.Optional;

public interface CurrencyRepository {

    /**
     * Find currency by currency code.
     *
     * @param currencyCode of selected currency.
     * @return optional {@link BigDecimal}.
     */
    Optional<BigDecimal> getExchangeRate(final String currencyCode);

}
