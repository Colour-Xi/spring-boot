package top.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${my.feature.helloSwitch}")
    private boolean isHelloEnabled;

    @Value("${my.feature.closeMsg}")
    private String closeMessage;

    @GetMapping("/hellos")
    public String hellos() {
        if(isHelloEnabled) {
            return "接口开放中。。。";
        }else {
            return closeMessage;
        }
    }
}
