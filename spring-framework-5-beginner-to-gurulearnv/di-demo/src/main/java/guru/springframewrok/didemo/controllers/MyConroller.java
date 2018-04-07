package guru.springframewrok.didemo.controllers;

import guru.springframewrok.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyConroller {

    @Autowired
    private GreetingService greetingService;

    public String hello() {
        return greetingService.sayGreeting();
    }
}
