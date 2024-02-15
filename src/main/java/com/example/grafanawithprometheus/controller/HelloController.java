package com.example.grafanawithprometheus.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private static final Log logger = LogFactory.getLog(HelloController.class);

    public final RestTemplate restTemplate;

    public HelloController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello")
    public String getHello(){
        logger.info("> getHello from bin");
        ResponseEntity<String> helloFromBin = restTemplate.postForEntity("https://httpbin.org/post", "Hello from bin", String.class);
        logger.info("< getHello method completed");
        return helloFromBin.getBody();
    }

}
