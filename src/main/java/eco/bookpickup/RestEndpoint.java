package eco.bookpickup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import eco.bookpickup.model.Book;
import eco.bookpickup.model.PickUpDetail;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class RestEndpoint {

    Map<String, Book> keyToBook;
    List<PickUpDetail> schedule;
    SearchService searchService;

    public RestEndpoint(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping("/{query}")
    public ApiResponse search(@PathVariable String query) throws JsonProcessingException {

        String json = searchService.search(query);

//        return response;
        return jsonToBookList(json);
    }


    private ApiResponse jsonToBookList(String raw) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ApiResponse apiResponse = objectMapper.readValue(raw,ApiResponse.class);

        keyToBook=new HashMap<>();
        for (Book book : apiResponse.works) {
            keyToBook.put(book.getKey(),book);
        }

        return apiResponse;
    }


    @PostMapping("/schedule")
    public void submitSchedule(@RequestBody PickUpRequest pickUpRequest) {
        if (schedule ==null)
            schedule = new ArrayList<>();

        PickUpDetail pickUpDetail = new PickUpDetail(pickUpRequest);
        pickUpDetail.setBook(keyToBook.get(pickUpRequest.bookKey));
        schedule.add(pickUpDetail);
    }

    @GetMapping("/schedule")
    public List<PickUpDetail> listSchedule() {
        return schedule;
    }

}
