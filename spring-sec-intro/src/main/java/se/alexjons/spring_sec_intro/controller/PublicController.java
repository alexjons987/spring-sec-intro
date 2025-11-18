package se.alexjons.spring_sec_intro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.alexjons.spring_sec_intro.service.PublicService;

@RestController
@RequestMapping("/public")
public class PublicController {

    PublicService publicService;

    public PublicController(PublicService publicService) {
        this.publicService = publicService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> greetPublic() {
        return ResponseEntity.ok(publicService.greet());
    }
}
