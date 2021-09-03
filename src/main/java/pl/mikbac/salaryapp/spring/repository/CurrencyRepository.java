package pl.mikbac.salaryapp.spring.repository;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by MikBac on 07.09.2019
 */

public interface CurrencyRepository {

    /**
     * Find currency by currency code.
     *
     * @param currencyCode of selected currency.
     * @return optional {@link BigDecimal}.
     */
    Optional<BigDecimal> getExchangeRate(final String currencyCode);

}