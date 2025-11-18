package se.alexjons.spring_sec_intro.service;

import org.springframework.stereotype.Service;

@Service
public class PublicService {

    public String greet() {
        return "Hello public World!";
    }
}
