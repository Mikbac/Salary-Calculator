package Entities;

import javax.persistence.*;
import ExchangeRateFromApi.ExchangeRate;

@Entity
@Table(name = "country")
public class Country {

    @Id
    private String countrCode;
    private double tax;
    private double fixedCosts;
    private String currencyCode;
    private double exchangeRate;


    public Country(String countrCode, double tax, double fixedCosts, String currencyCode) {
        this.countrCode = countrCode;
        this.tax = tax;
        this.fixedCosts = fixedCosts;
        this.currencyCode = currencyCode;
        exchangeRate = ExchangeRate.getExchangeRate(countrCode);
    }


}
