package com.pack.SpringBootDevtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
   @GetMapping("/hello")
    public String getHello() 
    {
      return "Hello World-Springs safadasfs fsfasf";
    }
   
   
}