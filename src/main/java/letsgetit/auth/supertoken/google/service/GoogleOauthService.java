package letsgetit.auth.supertoken.google.service;

import letsgetit.auth.supertoken.google.domain.GoogleResult;
import letsgetit.auth.supertoken.google.feign.GoogleFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Service
public class GoogleOauthService {

    private static final String CLIENT_ID = "133937347867-1hd94tgvl87f2pe197qjeo95ljjtcj8n.apps.googleusercontent.com";
    private static final String GOOGLE_CLIENT_ID = CLIENT_ID;
    private static final String GOOGLE_CLIENT_SECRET = "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";
    private static final String AUTH_URI = "https://accounts.google.com/o/oauth2/auth";
    private static final String SCOPE ="https://www.googleapis.com/auth/userinfo.profile";
    private static final String REDIRECT_URI = "http://localhost:8080/home";
    private static final String ERROR_URI = "http://localhost:8080/error";
    private static final String STATE = "my love ejejejejejejejejejejejejejejejej";
    private static final String TOKEN_URI = "https://oauth2.googleapis.com/token";
    private static final String GOOGLE_USER_INFO = "https://www.googleapis.com/oauth2/v2/userinfo";

    private final GoogleFeignClient googleFeignClient;

    public String getCodeFromProvider() {

        return AUTH_URI + "?" +
                "client_id=" + CLIENT_ID +
                "&redirect_uri=" + REDIRECT_URI +
                "&response_type=code" +
                "&scope=openid " + SCOPE +
                "&access_type=offline" +
                "&state=" + STATE;
    }

    public ResponseEntity<String> getToken(String code, String state) {

        RestTemplate restTemplate = new RestTemplate();

        if (!STATE.equals(state)) {
            return  ResponseEntity.badRequest().body("Error");
        }

        JSONObject object = new JSONObject();
        object.put("client_id",GOOGLE_CLIENT_ID);
        object.put("client_secret", GOOGLE_CLIENT_SECRET);
        object.put("code", code);
        object.put("redirect_uri", REDIRECT_URI);
        object.put("grant_type", "authorization_code");

        HttpEntity<JSONObject> httpRequestEntity = new HttpEntity<>(object);
        ResponseEntity<GoogleResult> response = restTemplate.postForEntity(TOKEN_URI, httpRequestEntity, GoogleResult.class);

        GoogleResult result = response.getBody();

        if(result != null && result.getAccessToken() != null) {
            // access token 을 사용하여 Google API 호출
            log.info("this is token info : {}", response.getBody());
            return restTemplate.getForEntity(String.format("%s?access_token=%s", GOOGLE_USER_INFO, result.getAccessToken()), String.class);
        }
        return  ResponseEntity.badRequest().body("Error");
    }
}
