/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSalaryFromClientException extends RuntimeException {
    public InvalidSalaryFromClientException(String salaryFromClient) {
        super("Invalid value from client for: " + salaryFromClient);
    }
}
