package pl.mikbac.salary_app.exception;

/**
 * Created by MikBac on 17.08.2019
 */

public class ExchangeRateNotFoundException extends RuntimeException {
    public ExchangeRateNotFoundException(final String countryCode) {
        super("ExchangeRate not found for code: " + countryCode);
    }
}
