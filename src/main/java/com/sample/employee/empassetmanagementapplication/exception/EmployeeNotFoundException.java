package com.sample.employee.empassetmanagementapplication.exception;


import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends RuntimeException {
    // Getter for message
    private final String errorMessage;
    // Getter for status code
    private final int httpStatusCode;

    // Constructor
    public EmployeeNotFoundException(String errorMessage, int httpStatusCode) {
        super(errorMessage); // passes message to RuntimeException
        this.errorMessage = errorMessage;
        this.httpStatusCode = httpStatusCode;
    }

}

