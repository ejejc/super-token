package letsgetit.auth.supertoken.google.domain;

import lombok.Builder;

public class GoogleOAuthRequest {

    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String grantType;

    @Builder
    public GoogleOAuthRequest(String clientId, String clientSecret, String code, String redirectUri, String grantType) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.redirectUri = redirectUri;
        this.grantType = grantType;
    }
}
