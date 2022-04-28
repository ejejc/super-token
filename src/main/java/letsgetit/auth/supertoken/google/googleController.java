package letsgetit.auth.supertoken.google;

import letsgetit.auth.supertoken.google.service.GoogleOauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/google")
public class googleController {

    private final GoogleOauthService googleOauthService;

    @GetMapping("/oauth/login")
    public ResponseEntity<Object> login() {
        HttpHeaders headers = googleOauthService.getCode();
        if(headers != null){
            return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
        }
        return ResponseEntity.badRequest().build();
    }
}
