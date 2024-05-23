package study.soowan.webservice.service;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.soowan.webservice.web.domain.posts.Posts;
import study.soowan.webservice.web.domain.posts.PostsRepository;
import study.soowan.webservice.web.dto.PostsMainResponseDto;
import study.soowan.webservice.web.dto.PostsSaveRequestDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After("")
    void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    void Dto데이터가_posts테이블에_저장된다() {
        // given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("테스트 타이틀")
                .content("테스트")
                .author("test@gmail.com")
                .build();

        // when
        postsService.save(dto);

        // then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    void posts테이블_내림차순조회() {
        // when
        List<PostsMainResponseDto> result = postsService.findAllDesc();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getId()).isEqualTo(2);
        assertThat(result.get(1).getId()).isEqualTo(1);
    }
}