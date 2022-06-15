package com.example.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallbackMethod")
    public String userServiceFallbackMethod(Exception e){
        return "User Service is taking more than expected. Please try again later.";
    }

    @GetMapping("/departmentServiceFallbackMethod")
    public String departmentServiceFallbackMethod(Exception e){
        return "Department Service is taking more than expected. Please try again later.";
    }

}
