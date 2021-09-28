package pl.mikbac.salary_app.exception;

/**
 * Created by MikBac on 2018
 */

public class InvalidSalaryFromClientException extends RuntimeException {
    public InvalidSalaryFromClientException(String salaryFromClient) {
        super("Invalid value from client for: " + salaryFromClient);
    }
}
