package letsgetit.auth.supertoken.google.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "google-feign-client", url = "https://www.googleapis.com")
public interface GoogleFeignClient {

    @GetMapping("/oauth2/v2/userinfo")
     public ResponseEntity<String> getLogin(
        @RequestHeader(value = "Authorization") String headerToken,
        @RequestParam(value = "alt") String alt,
        @RequestParam(value="access_token") String token

    );
}
