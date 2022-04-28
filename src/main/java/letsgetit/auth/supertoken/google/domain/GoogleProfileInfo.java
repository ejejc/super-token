package letsgetit.auth.supertoken.google.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GoogleProfileInfo {
    private String id;
    private String name;
    private String givenName;
    private String familyName;
    private String picture;
    private String locale;
}
