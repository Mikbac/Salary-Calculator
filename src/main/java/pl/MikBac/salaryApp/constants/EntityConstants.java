/**
 * Created by MikBac on 2019
 */

package pl.MikBac.salaryApp.constants;

public interface EntityConstants {

    interface Model {
        String PK = "pk";
    }

    interface Country {
        String TABLE = "Country";
        String COUNTRY_CODE = "countryCode";
        String TAX = "tax";
        String FIXED_COSTS = "fixedCosts";
        String CURRENCY_CODE = "currencyCode";
    }

}
