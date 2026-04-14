package edu.cibertec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthCallbackController {

    @GetMapping("/authorized")
    public String authorized() {
        return "Probar aqui: http://localhost:8080/oauth2/authorize?client_id=admin&redirect_uri=https%3A%2F%2Foauthdebugger.com%2Fdebug&scope=openid&response_type=code&response_mode=form_post&state=pi63ta2oalg&nonce=vfutmtv9xui";
    }
}
