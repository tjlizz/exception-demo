package com.github.exception.demo.api;


import com.github.exception.demo.exception.http.ParameterException;
import com.github.exception.demo.exception.http.ServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TestController {

    @GetMapping("test")
    public ResponseEntity test() {


       int a=1/0;


        return ResponseEntity.status(HttpStatus.OK).body("hello");

    }

}
