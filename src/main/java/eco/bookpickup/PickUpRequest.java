package eco.bookpickup;

import eco.bookpickup.model.PickUp;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class PickUpRequest extends PickUp {

    @Schema(example = "/works/OL21177W")
    String bookKey;

}
