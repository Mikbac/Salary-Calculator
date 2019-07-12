package pl.MikBac.salaryApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MikBac on 2018
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCountryIdException extends RuntimeException{
    public InvalidCountryIdException() {
        super("This country code does not exist!");
    }
}
