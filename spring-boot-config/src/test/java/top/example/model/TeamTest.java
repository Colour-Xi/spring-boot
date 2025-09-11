package top.example.model;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Slf4j
class TeamTest {
    @Resource
    private Team team;

    @Test
    void testTeam(){
        log.info("测试Team类");
        log.info("team={}",team);

        assertEquals("Web2班",team.getName());
        assertEquals("王伟",team.getLeader());
    }
}