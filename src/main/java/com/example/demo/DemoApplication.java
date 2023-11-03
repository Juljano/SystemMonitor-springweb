package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {


    @GetMapping("/hello")
    public String sayHelloWord() {

        return "Hello Word!";
    }

    @GetMapping("/sum")
    public int sum() {

        return 12 + 43;
    }


    @GetMapping("/index")
    public String showHTMLPage() {

        return "index.html";
    }

    @RequestMapping("/not-found")
    public String notFound() {

        return "404.html";
    }

    @RequestMapping("/error")
    public String error() {

        return "Error! Please check your domain of correctness!";
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

}
