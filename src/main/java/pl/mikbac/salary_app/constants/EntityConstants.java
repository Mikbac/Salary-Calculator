package pl.mikbac.salary_app.constants;

/**
 * Created by MikBac on 2019
 */

public interface EntityConstants {

    interface Model {
        String PK = "pk";
        String UPDATE_TIME = "updateTime";
        String CREATION_TIME = "creationTime";
    }

    interface Country {
        String TABLE = "Country";
        String COUNTRY_CODE = "countryCode";
        String TAX = "tax";
        String FIXED_COSTS = "fixedCosts";
        String CURRENCY_CODE = "currencyCode";
    }

}
