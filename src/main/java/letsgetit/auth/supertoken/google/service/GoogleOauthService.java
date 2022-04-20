package letsgetit.auth.supertoken.google.service;

import com.sun.istack.Nullable;
import java.util.List;
import java.util.Objects;
import letsgetit.auth.supertoken.google.domain.GoogleOAuthRequest;
import letsgetit.auth.supertoken.google.domain.GoogleResult;
import letsgetit.auth.supertoken.google.feign.GoogleFeignClient;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleOauthService {

    @Autowired
    private  GoogleFeignClient googleFeignClient;

    private static final String GOOGLE_CLIENT_ID = "133937347867-1hd94tgvl87f2pe197qjeo95ljjtcj8n.apps.googleusercontent.com";
    private static final String GOOGLE_CLIENT_SECRET = "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";
    private static final String REDIRECT_URL = "http://localhost:8080/home";
    private static final String TYPE = "code";
    private static final String SCOPE ="https://www.googleapis.com/auth/userinfo.profile";

    public void getToken(String code) {
        RestTemplate restTemplate = new RestTemplate();

        GoogleOAuthRequest request = GoogleOAuthRequest.builder()
            .clientId(GOOGLE_CLIENT_ID)
            .clientSecret(GOOGLE_CLIENT_SECRET)
            .code(code)
            .redirectUri(REDIRECT_URL)
            .grantType("authorization_code").build();

        JSONObject object = new JSONObject();
        object.put("client_id",GOOGLE_CLIENT_ID);
        object.put("client_secret", GOOGLE_CLIENT_SECRET);
        object.put("code", code);
        object.put("redirect_uri", REDIRECT_URL);
        object.put("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<JSONObject> httpRequestEntity = new HttpEntity<>(object, headers);
        ResponseEntity<GoogleResult> response = restTemplate.postForEntity("https://oauth2.googleapis.com/token", httpRequestEntity, GoogleResult.class);

        GoogleResult result = response.getBody();
        if(Objects.nonNull(result.getAccessToken())) {
            // access token 을 사용하여 Google API 호출
            ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.googleapis.com/oauth2/v2/userinfo?access_token" +result.getAccessToken(), String.class);
        }
    }
}
