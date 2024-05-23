package study.soowan.webservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.soowan.webservice.web.domain.posts.PostsRepository;
import study.soowan.webservice.web.dto.PostsMainResponseDto;
import study.soowan.webservice.web.dto.PostsSaveRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
