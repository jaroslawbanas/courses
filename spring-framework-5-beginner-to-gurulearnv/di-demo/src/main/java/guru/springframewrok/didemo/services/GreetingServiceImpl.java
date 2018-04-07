package guru.springframewrok.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO_AAA = "Hello AAA";

    @Override
    public String sayGreeting() {
        return HELLO_AAA;
    }
}
