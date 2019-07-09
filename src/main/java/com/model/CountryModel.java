package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = PreferNames.Table.COUNTRY)
public class CountryModel {

    @Id
    @Column(name = PreferNames.Country.COUNTRY_CODE)
    private String countryCode;

    @Column(name = PreferNames.Country.TAX)
    private BigDecimal tax;

    @Column(name = PreferNames.Country.FIXED_COSTS)
    private BigDecimal fixedCosts;

    @Column(name = PreferNames.Country.CURRENCY_CODE)
    private String currencyCode;

}
