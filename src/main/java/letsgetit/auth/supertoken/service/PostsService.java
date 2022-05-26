package letsgetit.auth.supertoken.service;

import letsgetit.auth.supertoken.domain.Posts;
import letsgetit.auth.supertoken.domain.PostsRepository;
import letsgetit.auth.supertoken.web.dto.PostsListResponseDto;
import letsgetit.auth.supertoken.web.dto.PostsResponseDto;
import letsgetit.auth.supertoken.web.dto.PostsSaveRequestDto;
import letsgetit.auth.supertoken.web.dto.PostsUpdateRequestDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("해당 게시글이 없습니다. id = %d", id)));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("해당 게시글이 없습니다. id = %d", id)));
        return new PostsResponseDto(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
