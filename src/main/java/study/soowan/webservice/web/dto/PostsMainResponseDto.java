package study.soowan.webservice.web.dto;

import lombok.Getter;
import study.soowan.webservice.web.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsMainResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = entity.getModifiedDate();
    }
}
