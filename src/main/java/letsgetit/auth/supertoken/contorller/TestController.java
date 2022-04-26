package letsgetit.auth.supertoken.contorller;

import letsgetit.auth.supertoken.google.service.GoogleOauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final GoogleOauthService googleOauthService;

    @GetMapping ("/home")
    public ResponseEntity<String> home(@RequestParam String code, @RequestParam String state) {
       return googleOauthService.getToken(code, state);
    }

    @GetMapping ("/error")
    public ResponseEntity<String> error() {
        return ResponseEntity.badRequest().body("OAuth Flow Error");
    }
}
