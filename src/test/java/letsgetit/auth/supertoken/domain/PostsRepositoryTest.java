package letsgetit.auth.supertoken.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("dkstpgud@gmail.com")
                        .build()
        );

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertEquals(posts.getTitle(), title);
        assertEquals(posts.getTitle(), title);
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.of(2022, 5, 19, 0, 0, 0);
        postsRepository.save(
                Posts.builder()
                        .title("title")
                        .content("content")
                        .author("dkstpgud@gmail.com")
                        .build()
        );

        // when
        List<Posts> all = postsRepository.findAll();

        // then
        Posts posts = all.get(0);
        Assertions.assertThat(posts.getCreatedDate()).isAfter(now);
        Assertions.assertThat(posts.getModifiedDate()).isAfter(now);
    }

}