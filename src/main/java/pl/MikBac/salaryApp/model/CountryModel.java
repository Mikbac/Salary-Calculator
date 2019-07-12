package pl.MikBac.salaryApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by MikBac on 2018
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = EntitiesNames.Country.TABLE)
public class CountryModel {

    @Id
    @Column(name = EntitiesNames.Country.COUNTRY_CODE)
    private String countryCode;

    @Column(name = EntitiesNames.Country.TAX)
    private BigDecimal tax;

    @Column(name = EntitiesNames.Country.FIXED_COSTS)
    private BigDecimal fixedCosts;

    @Column(name = EntitiesNames.Country.CURRENCY_CODE)
    private String currencyCode;

}
