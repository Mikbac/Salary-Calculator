package pl.mikbac.salary_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mikbac.salary_app.constants.EntityConstants.Country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static pl.mikbac.salary_app.constants.GlobalConstants.Regex;

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
public class CountryModel extends AbstractModel implements Serializable {

    @NotBlank
    @Pattern(regexp = Regex.ONLY_BIG_LETTERS)
    @Column(name = Country.COUNTRY_CODE)
    private String countryCode;

    @NotNull
    @Column(name = Country.TAX)
    private BigDecimal tax;

    @NotNull
    @Column(name = Country.FIXED_COSTS)
    private BigDecimal fixedCosts;

    @NotBlank
    @Pattern(regexp = Regex.ONLY_BIG_LETTERS)
    @Column(name = Country.CURRENCY_CODE)
    private String currencyCode;

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof CountryModel)) return false;
        final CountryModel that = (CountryModel) o;
        return this.countryCode.equals(that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryCode());
    }
}
