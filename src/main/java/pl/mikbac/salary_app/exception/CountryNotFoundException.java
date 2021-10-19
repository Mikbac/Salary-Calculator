package pl.mikbac.salary_app.exception;

/**
 * Created by MikBac on 17.08.2019
 */

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(final String countryCode) {
        super("Country not found for code: " + countryCode);
    }
}
