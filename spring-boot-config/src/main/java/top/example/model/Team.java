package top.example.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Team {

    @Value("${team.name}")
    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 3, max = 20, message = "长度在3-20之间")
    private String name;

    @Value("${team.phone}")
    @Pattern(regexp = "^1[3-9]\\d{8}$", message = "手机号格式不正确")
    private String phone;

    @Value("${team.leader}")
    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 3, max = 8, message = "长度在3-8之间")
    private String leader;

    @NotNull
    @Max(value = 4, message = "年龄不能大于4")
    @Min(value = 1, message = "年龄不能小于1")
    private String age;
}
