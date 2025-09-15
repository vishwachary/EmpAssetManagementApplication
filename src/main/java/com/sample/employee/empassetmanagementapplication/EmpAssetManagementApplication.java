package com.sample.employee.empassetmanagementapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sample.employee.empassetmanagementapplication"})
public class EmpAssetManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpAssetManagementApplication.class, args);
    }

}
