package letsgetit.auth.supertoken.contorller;

import letsgetit.auth.supertoken.google.service.GoogleOauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @Autowired
    private GoogleOauthService googleOauthService;

    @GetMapping ("/home")
    public void home(@RequestParam String code) {
       googleOauthService.getToken(code);
    }
//
//    @GetMapping("/")
//    public String main() {
//        return "hello";
//    }
}
