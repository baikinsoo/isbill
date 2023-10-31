package com.isbill;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginCheckController {

    @GetMapping("/checkLogin")
    public boolean checkLogin() {
        // Spring Security를 사용하여 현재 사용자의 인증 상태를 확인
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 사용자가 인증되어 있으면 true, 그렇지 않으면 false 반환
        return authentication.isAuthenticated();
    }
}
