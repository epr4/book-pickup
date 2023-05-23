package eco.bookpickup.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Setter;

@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Author {
    String name;
}
