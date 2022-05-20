package com.diary.DiaryProject.config;

import com.diary.DiaryProject.services.GroupService;
import com.diary.DiaryProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userServiceImpl;


    @Autowired
    GroupService groupServiceImpl;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/login", "/registrationBase", "/registrationStudent", "/registrationTeacher").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/homeworkViewStudent").hasAuthority("STUDENT")
                .antMatchers("/addHomework").hasAuthority("TEACHER")
                .antMatchers("/homeworkListViewTeacher").hasAuthority("TEACHER")
                .antMatchers("/groupViewTeacher").hasAuthority("TEACHER")
                .antMatchers("/homeworkListByGroup={id}").hasAuthority("TEACHER")
                .antMatchers("/homeworkViewTeacher={id}").hasAuthority("TEACHER")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/resources/**").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/j_spring_security_check")
                .failureUrl("/j_spring_security_check?error")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .logoutUrl("/j_spring_security_logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .sessionManagement()
                .maximumSessions(5)
                .expiredUrl("/login")
                .and()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access/denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
    }
}
