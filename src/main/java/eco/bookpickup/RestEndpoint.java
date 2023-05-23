package eco.bookpickup;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestEndpoint {

    @GetMapping("/{query}")
    public ResponseEntity<String> homePage(@PathVariable String query)
    {

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "https://openlibrary.org/subjects/"+query+".json";
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);
        return response;
    }

}
