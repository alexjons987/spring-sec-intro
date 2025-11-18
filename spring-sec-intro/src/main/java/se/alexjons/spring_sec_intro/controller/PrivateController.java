package se.alexjons.spring_sec_intro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.alexjons.spring_sec_intro.service.PrivateService;

@RestController
@RequestMapping("/private")
public class PrivateController {

    PrivateService privateService;

    public PrivateController(PrivateService privateService) {
        this.privateService = privateService;
    }

    @GetMapping("/secret")
    public ResponseEntity<String> greetPrivate() {
        return ResponseEntity.ok(privateService.greet());
    }
}
