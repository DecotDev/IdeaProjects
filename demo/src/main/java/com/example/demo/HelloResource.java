package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HelloResource.HELLO_RESOURCE)
public class HelloResource {
    public static final String HELLO_RESOURCE = "/hello";

    @GetMapping()
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/bye")
    public String bye(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Bye %s!", name);
    }

}
