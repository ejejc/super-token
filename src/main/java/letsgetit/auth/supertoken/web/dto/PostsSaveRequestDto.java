package letsgetit.auth.supertoken.web.dto;

import letsgetit.auth.supertoken.domain.post.Posts;
import lombok.*;

@Getter
@Builder
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
