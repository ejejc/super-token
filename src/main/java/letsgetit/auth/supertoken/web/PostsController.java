package letsgetit.auth.supertoken.web;

import letsgetit.auth.supertoken.service.EnumService;
import letsgetit.auth.supertoken.service.MustacheService;
import letsgetit.auth.supertoken.service.PostsService;
import letsgetit.auth.supertoken.web.dto.PostsResponseDto;
import letsgetit.auth.supertoken.web.dto.PostsSaveRequestDto;
import letsgetit.auth.supertoken.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class PostsController {

    private final PostsService postsService;
    private final MustacheService mustacheService;
    private final EnumService enumService;

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/posts")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }


    @GetMapping("/mustache")
    public void mustacheTest() {
        mustacheService.testMustache();
    }

    @GetMapping("/enum")
    public void enumTest() {
        enumService.test();
    }
}
