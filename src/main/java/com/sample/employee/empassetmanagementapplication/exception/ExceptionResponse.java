package com.sample.employee.empassetmanagementapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class ExceptionResponse
{   private LocalDate timestamp;
    private String message;
    private String details;
}
