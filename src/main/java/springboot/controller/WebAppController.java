package springboot.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Started a SpringBoot Application to be used with Vue and Bootstrap
 * @TODO - Yet to be implemented
 */
@SpringBootApplication
public class WebAppController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


}

