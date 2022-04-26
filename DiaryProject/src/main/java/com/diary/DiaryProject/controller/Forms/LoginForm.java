package com.diary.DiaryProject.controller.Forms;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginForm {
    @NotEmpty
    @Size(min = 2, message = "Логин не может быть меньше двух знаков")
    String login;
    @NotEmpty
    @Size(min = 2, message = "Логин не может быть меньше двух знаков")
    String password;


}
