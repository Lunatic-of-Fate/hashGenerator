package org.lunatic.controllers;


import lombok.AllArgsConstructor;
import org.lunatic.DTO.HashDTO;
import org.lunatic.services.HashService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
@AllArgsConstructor
public class HashGeneratorController {
    private final HashService hashService;

    @GetMapping("/get")
    public HashDTO get() {
        return hashService.create();
    }
}
