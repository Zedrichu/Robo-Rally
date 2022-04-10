package springboot.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AppController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}

