package letsgetit.auth.supertoken.config.auth;

import letsgetit.auth.supertoken.superproject.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
                .authorizeRequests() // url별, 권한 관리 설정 옵션
                 // 아래 URL들은 전체 열람 권한 부여 (permitAll)
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**")
                .permitAll()
                 // 아래 URL들은 USER 권한을 가진 사람만 가능하도록 설정
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                 // 설정된 URL 외의 나머지 URL들을 나타낸다.
                .anyRequest().authenticated()   // authenticated = 인증된 사용자들만 허용하도록 설정 (= 로그인 사용자)
            .and()
                .logout()
                    .logoutSuccessUrl("/") // 로그아웃 성공시 해당 URL로 이동
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                        .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행 할 서비스단
    }
}
