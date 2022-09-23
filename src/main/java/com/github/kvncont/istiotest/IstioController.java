package com.github.kvncont.istiotest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IstioController {

    @GetMapping("/error")
    public ResponseEntity<String> generateReport() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "Spring Boot Code");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(responseHeaders, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @GetMapping("/ok")
    public ResponseEntity<String> test() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "Spring Boot Code");
        return new ResponseEntity<String>("hello world" ,responseHeaders, HttpStatus.OK);
    }
}
