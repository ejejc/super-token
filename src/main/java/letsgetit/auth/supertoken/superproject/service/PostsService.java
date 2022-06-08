package letsgetit.auth.supertoken.superproject.service;

import java.util.List;
import java.util.stream.Collectors;
import letsgetit.auth.supertoken.superproject.domain.posts.Posts;
import letsgetit.auth.supertoken.superproject.domain.posts.PostsRepository;
import letsgetit.auth.supertoken.superproject.web.dto.PostsListResponseDto;
import letsgetit.auth.supertoken.superproject.web.dto.PostsResponseDto;
import letsgetit.auth.supertoken.superproject.web.dto.PostsSaveRequestDto;
import letsgetit.auth.supertoken.superproject.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private String a = "";
    public Long save(PostsSaveRequestDto postsRequestDto) {
        return postsRepository.save(postsRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
            .map(PostsListResponseDto::new) // new PostsListResponseDto(Posts) 와 같다.
            .collect(Collectors.toList());
    }
}
