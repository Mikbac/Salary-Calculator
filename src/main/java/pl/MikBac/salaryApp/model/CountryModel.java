package pl.MikBac.salaryApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.MikBac.salaryApp.constants.EntityConstants.Country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by MikBac on 2018
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = Country.TABLE)
public class CountryModel extends Model implements Serializable {

    @NotNull
    @Column(name = Country.COUNTRY_CODE)
    private String countryCode;

    @NotNull
    @Column(name = Country.TAX)
    private BigDecimal tax;

    @NotNull
    @Column(name = Country.FIXED_COSTS)
    private BigDecimal fixedCosts;

    @NotNull
    @Column(name = Country.CURRENCY_CODE)
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
