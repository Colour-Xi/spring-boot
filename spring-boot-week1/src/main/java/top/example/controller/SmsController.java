package top.example.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.example.service.SmsService;

@RestController
public class SmsController {
    @Resource
    private SmsService smsService;

    @GetMapping(".sms")
    public void sendSms(String phoneNumber) {
        smsService.sendSms(phoneNumber);
    }
}
