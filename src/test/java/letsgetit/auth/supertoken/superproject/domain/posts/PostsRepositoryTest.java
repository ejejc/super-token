package letsgetit.auth.supertoken.superproject.domain.posts;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    // 단위 테스트가 끝날때 마다 수행되는 메소드
    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
        .title(title)
        .content(content)
        .author("ejejc@naver.com").build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }
}