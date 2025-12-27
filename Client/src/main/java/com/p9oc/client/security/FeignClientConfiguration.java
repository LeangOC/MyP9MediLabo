package com.p9oc.client.security;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public RequestInterceptor jwtInterceptor() {
        return template -> {
            ServletRequestAttributes attrs =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            if (attrs != null) {
                HttpSession session = attrs.getRequest().getSession(false);
                if (session != null) {
                    String jwt = (String) session.getAttribute("JWT");
                    //System.out.println(">>> Feign JWT = " + jwt);
                    if (jwt != null) {
                        template.header("Authorization", "Bearer " + jwt);
                    }
                } else {
                    System.out.println(">>> NO SESSION");
                }
            } else {
                System.out.println(">>> NO REQUEST ATTRIBUTES");
                    }


        };
    }
}
