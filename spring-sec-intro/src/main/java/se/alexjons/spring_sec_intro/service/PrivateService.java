package se.alexjons.spring_sec_intro.service;

import org.springframework.stereotype.Service;

@Service
public class PrivateService {

    public String greet() {
        return "Hello secret World!";
    }
}
