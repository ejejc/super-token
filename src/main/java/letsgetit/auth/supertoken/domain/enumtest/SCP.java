package letsgetit.auth.supertoken.domain.enumtest;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


public interface SCP {
        String getEventContent();
}
