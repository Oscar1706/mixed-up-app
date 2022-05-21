package ojbv.identity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class HelloRestController {
    
    @GetMapping("users")
    public String helloUser(){
        return "Hello user";
    }

    @GetMapping("admins")
    public String helloAdmin(){
        return "Hello admin";
    }
}
