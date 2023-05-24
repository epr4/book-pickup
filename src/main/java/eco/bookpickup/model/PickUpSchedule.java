package eco.bookpickup.model;

import lombok.Getter;

import java.util.Date;


@Getter
public class PickUpSchedule {

    Date when;
    String who;

    String bookKey;
    Book book;

}
