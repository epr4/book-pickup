package eco.bookpickup.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Setter;

import java.util.List;


@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Book {

    String title;
    List<Author> authors;
    int editionCount;

}
