package restApi.entities;

import javax.persistence.*;


@Entity
@Table(name = "country")
public class Country {

    @Id
    private String countryCode;
    private double tax;
    private double fixedCosts;
    private String currencyCode;



    public Country(String countryCode, double tax, double fixedCosts, String currencyCode) {
        this.countryCode = countryCode;
        this.tax = tax;
        this.fixedCosts = fixedCosts;
        this.currencyCode = currencyCode;
    }

    public Country(){

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getFixedCosts() {
        return fixedCosts;
    }

    public void setFixedCosts(double fixedCosts) {
        this.fixedCosts = fixedCosts;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


}
