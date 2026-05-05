package edu.cibertec.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import edu.cibertec.util.JwtUtil;
import reactor.core.publisher.Mono;

@Component
public class LeerTokenFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {



        Authentication auth = JwtUtil.leerToken(exchange);

        if (auth == null) {
            return chain.filter(exchange);
        }
        return chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth));
    }
}