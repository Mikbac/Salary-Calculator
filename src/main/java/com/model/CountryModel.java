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
@Table(name = "country")
public class CountryModel {

    @Id
    private String countryCode;
    private BigDecimal tax;
    private BigDecimal fixedCosts;
    private String currencyCode;

}
