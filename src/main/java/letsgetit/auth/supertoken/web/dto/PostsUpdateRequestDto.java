package letsgetit.auth.supertoken.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
}
