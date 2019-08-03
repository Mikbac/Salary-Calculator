/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.MikBac.salaryApp.constants.EntitiesConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = EntitiesConstants.Country.TABLE)
public class CountryModel implements Serializable {

    @Id
    @Column(name = EntitiesConstants.Country.COUNTRY_CODE)
    private String countryCode;

    @Column(name = EntitiesConstants.Country.TAX)
    private BigDecimal tax;

    @Column(name = EntitiesConstants.Country.FIXED_COSTS)
    private BigDecimal fixedCosts;

    @Column(name = EntitiesConstants.Country.CURRENCY_CODE)
    private String currencyCode;

}
