package eco.bookpickup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestEndpoint {

    @GetMapping("/{query}")
    public ApiResponse homePage(@PathVariable String query) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "https://openlibrary.org/subjects/"+query+".json";
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);

//        return response;
        return raw2BookList(response.getBody());
    }

    private ApiResponse raw2BookList(String raw) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ApiResponse apiResponse = objectMapper.readValue(raw,ApiResponse.class);
        return apiResponse;
    }

}
