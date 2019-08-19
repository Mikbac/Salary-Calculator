/**
 * Created by MikBac on 17.08.2019
 */

package pl.MikBac.salaryApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String countryCode) {
        super("Country not found for code: " + countryCode);
    }
}
