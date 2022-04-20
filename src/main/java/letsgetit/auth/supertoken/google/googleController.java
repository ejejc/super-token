package letsgetit.auth.supertoken.google;

import java.net.URI;
import java.net.URISyntaxException;
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

    @Autowired
    private GoogleOauthService googleOauthService;

    @GetMapping("/oauth/login")
    public ResponseEntity<Object> login() {
        String authUrl = "https://accounts.google.com/o/oauth2/auth/oauthchooseaccount?client_id=133937347867-1hd94tgvl87f2pe197qjeo95ljjtcj8n.apps.googleusercontent.com&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fhome&response_type=code&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdrive.metadata.readonly&flowName=GeneralOAuthFlow&access_type=offline";
        URI redirectUri = null;
        try {
            redirectUri = new URI(authUrl);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(redirectUri);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }
}
