package com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {

    @Id
    private String countryCode;
    private BigDecimal tax;
    private BigDecimal fixedCosts;
    private String currencyCode;

}
