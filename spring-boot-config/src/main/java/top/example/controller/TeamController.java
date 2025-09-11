package top.example.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.example.model.Team;

@Slf4j
@RestController
@RequestMapping("/teams")
public class TeamController {

    @PostMapping("/add")
    public String createTeam(@Valid @RequestBody Team team) {
        log.info("wasd添加的团队信息：{}", team);
        return "login over";
    }
}
