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
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/google")
public class googleController {
    private final GoogleOauthService googleOauthService;

    @GetMapping("/oauth/login")
    public RedirectView login() {
        String redirectPath = googleOauthService.getCodeFromProvider();
        return new RedirectView(redirectPath);
    }
}
