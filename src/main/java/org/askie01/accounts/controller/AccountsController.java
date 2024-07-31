package org.askie01.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AccountsController {

    @GetMapping("sayHello")
    public String sayHello() {
        return "Hi World";
    }
}
