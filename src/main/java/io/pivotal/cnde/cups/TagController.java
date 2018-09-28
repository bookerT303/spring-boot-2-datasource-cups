package io.pivotal.cnde.cups;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/tags")
public class TagController {

    private TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {

        this.tagRepository = tagRepository;
    }

    @GetMapping
    public List<Tag> list() {
        return tagRepository.findAll().stream()
                .collect(toList());
    }
}
