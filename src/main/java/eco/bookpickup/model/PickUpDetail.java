package eco.bookpickup.model;

import eco.bookpickup.PickUpRequest;
import lombok.Data;


@Data
public class PickUpDetail extends PickUp {

    Book book;

    public PickUpDetail(Book book) {
        this.book=book;
    }

    public PickUpDetail(PickUpRequest pickUpRequest) {
        setWho(pickUpRequest.getWho());
        setWhen(pickUpRequest.getWhen());
    }
}
