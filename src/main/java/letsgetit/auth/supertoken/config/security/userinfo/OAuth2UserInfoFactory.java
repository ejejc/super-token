package letsgetit.auth.supertoken.config.security.userinfo;

import letsgetit.auth.supertoken.config.exception.OAuth2AuthenticationProcessingException;
import letsgetit.auth.supertoken.domain.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equals(AuthProvider.GOOGLE.toString().toLowerCase())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException(String.format("Sorry! Login with %s is not supported yet!", registrationId));
        }
    }
}
