package pl.mikbac.salary_app.exception;

/**
 * Created by MikBac on 2018
 */

public class InvalidApiAddressException extends RuntimeException {
    public InvalidApiAddressException(final String url) {
        super("Invalid API address for url: " + url);
    }
}
