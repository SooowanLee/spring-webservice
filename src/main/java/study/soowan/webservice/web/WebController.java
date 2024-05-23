package study.soowan.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.soowan.webservice.service.PostsService;
import study.soowan.webservice.web.dto.PostsSaveRequestDto;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("postsRequest", new PostsSaveRequestDto());
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
