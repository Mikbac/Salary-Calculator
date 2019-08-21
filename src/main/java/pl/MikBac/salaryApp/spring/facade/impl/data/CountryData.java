/**
 * Created by MikBac on 21.08.2019
 */

package pl.MikBac.salaryApp.spring.facade.impl.data;

import lombok.Getter;

@Getter
public class CountryData {

    private String countryCode;
    private String currencyCode;

    public static CountryBuilder prepare() {
        return new CountryBuilder();
    }

    public static final class CountryBuilder {

        private CountryData country;

        private CountryBuilder() {
            this.country = new CountryData();
        }

        public CountryBuilder withCountryCode(final String countryCode) {
            this.country.countryCode = countryCode;
            return this;
        }

        public CountryBuilder withCurrencyCode(final String currencyCode) {
            this.country.currencyCode = currencyCode;
            return this;
        }

        public CountryData build() {
            return this.country;
        }

    }
}
