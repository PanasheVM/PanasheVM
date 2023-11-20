package com.nmbz.servicedev.controlllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @GetMapping("/home")
    public String homeEndpoint() {
        return "Account Operations";
    }

    @GetMapping("/accountfreeze/")
    public String accountFreeze() {
        return "Account Freeze";
    }

}

