package eco.bookpickup.model;

import lombok.Data;
import lombok.Getter;

import java.util.Date;


@Data
public class PickUp {

    Date when;
    String who;

}
