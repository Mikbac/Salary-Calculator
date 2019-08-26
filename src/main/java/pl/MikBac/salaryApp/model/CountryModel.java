/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.MikBac.salaryApp.constants.EntitiesConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = EntitiesConstants.Country.TABLE)
public class CountryModel implements Serializable {

    @Id
    @NotNull
    @Column(name = EntitiesConstants.Country.COUNTRY_CODE)
    private String countryCode;

    @NotNull
    @Column(name = EntitiesConstants.Country.TAX)
    private BigDecimal tax;

    @NotNull
    @Column(name = EntitiesConstants.Country.FIXED_COSTS)
    private BigDecimal fixedCosts;

    @NotNull
    @Column(name = EntitiesConstants.Country.CURRENCY_CODE)
    private String currencyCode;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryModel)) return false;
        final CountryModel that = (CountryModel) o;
        return Objects.equals(getCountryCode(), that.getCountryCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryCode());
    }
}
