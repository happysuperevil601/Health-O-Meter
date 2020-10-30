package com.superdevs.HealthOMeter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestApi {
    @GetMapping("/forAll")
    public String forAll() {
        return "You have been logout";
    }

    @GetMapping("/forUser")
    public String forUser(Principal principal) {
        return "Hello user " + principal.getName();
    }

    @GetMapping("/forAdmin")
    public String forAdmin(Principal principal) {
        return "Hello admin " + principal.getName();
    }

    @GetMapping("/authenticated")
    public String authenticated(Principal principal) {
        return "Hello " + principal.getName() + ". You have been authenticated.";
    }
}
