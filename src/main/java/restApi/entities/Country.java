package restApi.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "country")
public class Country {

    @Id
    private String countryCode;
    private BigDecimal tax;
    private BigDecimal fixedCosts;
    private String currencyCode;


    public Country(String countryCode, BigDecimal tax, BigDecimal fixedCosts, String currencyCode) {
        this.countryCode = countryCode;
        this.tax = tax;
        this.fixedCosts = fixedCosts;
        this.currencyCode = currencyCode;
    }

    public Country() {

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getFixedCosts() {
        return fixedCosts;
    }

    public void setFixedCosts(BigDecimal fixedCosts) {
        this.fixedCosts = fixedCosts;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


}
