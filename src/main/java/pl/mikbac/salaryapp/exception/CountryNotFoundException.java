package pl.mikbac.salaryapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MikBac on 17.08.2019
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String countryCode) {
        super("Country not found for code: " + countryCode);
    }
}
