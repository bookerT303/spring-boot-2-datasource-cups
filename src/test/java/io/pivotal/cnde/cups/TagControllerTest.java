package io.pivotal.cnde.cups;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static io.pivotal.cnde.cups.TagBuilder.tagBuilder;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TagControllerTest {

    @Mock
    TagRepository repository;

    @Test
    public void list() {
        List<Tag> tagList = asList(
                tagBuilder().id(1).label("Tag1").build(),
                tagBuilder().id(2).label("Tag2").build()
        );
        when(repository.findAll()).thenReturn(tagList);

        TagController controller = new TagController(repository);

        List<Tag> tags = controller.list();

        assertThat(tags.size()).isEqualTo(2);
        assertThat(tags).containsAll(tagList);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }
}