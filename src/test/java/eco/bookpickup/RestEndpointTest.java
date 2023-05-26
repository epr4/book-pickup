package eco.bookpickup;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class RestEndpointTest {

    @Mock
    SearchService searchServiceMock;

    @org.junit.Test
    public void search() throws JsonProcessingException {
        String sample = """
                {
                    "key": "/subjects/love",
                    "name": "love",
                    "subject_type": "subject",
                    "work_count": 4918,
                    "works": [
                        {
                            "key": "/works/OL66534W",
                            "title": "Pride and prejudice",
                            "edition_count": 752,
                            "authors": [
                                {
                                    "name": "Jane Austen",
                                    "key": "/authors/OL21594A"
                                }
                            ],
                            "has_fulltext": true,
                            "ia": "mansfieldparknov03aust"
                        }
                    ]
                }""";
        when(searchServiceMock.search(anyString())).thenReturn(sample);
        RestEndpoint restEndpoint = new RestEndpoint(searchServiceMock);
        assertThat(restEndpoint.search("Q").works.get(0).getTitle(), is("Pride and prejudice"));
    }

}