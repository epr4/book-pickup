package eco.bookpickup;

import eco.bookpickup.model.PickUp;
import lombok.Data;


@Data
public class PickUpRequest extends PickUp {

    String bookKey;

}
