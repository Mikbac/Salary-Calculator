package pl.mikbac.salary_app.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.mikbac.salary_app.data.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

import static pl.mikbac.salary_app.constants.GlobalConstants.Regex;

/**
 * Created by MikBac on 07.09.2019
 */

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryData implements Data {

    @Pattern(regexp = Regex.ONLY_BIG_LETTERS)
    private String countryCode;

    @NotNull
    private BigDecimal tax;

    @NotNull
    private BigDecimal fixedCosts;

    @Pattern(regexp = Regex.ONLY_BIG_LETTERS)
    private String currencyCode;

}
