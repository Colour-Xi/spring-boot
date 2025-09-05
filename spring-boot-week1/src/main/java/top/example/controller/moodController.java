package top.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class moodController {

    @Value("${my.mood.today}")
    private String today;
    @Value("${my.mood.author}")
    private String author;
    @Value("${my.mood.eye}")
    private String eye;

    @GetMapping("/mood")
    public String mood() {
        return "今天是" + today +
                "，作者是" + author +
                ",眼睛是'" + eye;
    }
}
