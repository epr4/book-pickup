package eco.bookpickup;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchService {

    @Cacheable("subjects")
    String search(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "https://openlibrary.org/subjects/"+ query +".json";
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);
        String body = response.getBody();
        return body;
    }

}
