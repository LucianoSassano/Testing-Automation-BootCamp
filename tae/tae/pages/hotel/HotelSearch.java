package con.bootcamp.tae.pages.hotel;

import com.bootcamp.tae.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HotelSearch extends WebPage {

    @FindBy(css = ".sbox-destination.sbox-primary")
    private WebElement destinationInput;

    @FindBy(css = ".ac-group-container .item")
    private List<WebElement> suggestionsDropdown;

    @FindBy(css = ".sbox-checkin-date")
    private WebElement checkInInput;

    //TODO: @FindBy
    private WebElement checkOutInput;

    //TODO: @FindBy
    private WebElement roomsInput;

    //TODO: @FindBy
    private WebElement roomsContainer;

    @FindBy(css = "#searchbox-sbox-box-hotels .sbox-search")
    private WebElement searchButton;

    public HotelSearch typeDestination(String destination) {
        type(destinationInput, destination);
        click(suggestionsDropdown.get(0));
        return this;
    }

    public HotelSearch selectCheckIn() {
        // TODO Delegate checkIn selection to Calendar
        return this;
    }

    public HotelSearch selectCheckOut() {
        // TODO Delegate checkOut selection to Calendar
        return this;
    }

    public HotelSearch selectChildren() {
        // TODO Select children and age
        return this;
    }

    public HotelSearchResults search() {
        click(searchButton);
        return new HotelSearchResults();
    }


}
