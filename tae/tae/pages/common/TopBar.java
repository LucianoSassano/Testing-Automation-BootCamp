package con.bootcamp.tae.pages.common;

import com.bootcamp.tae.page.web.WebComponent;
import con.bootcamp.tae.pages.hotel.HotelSearch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBar extends WebComponent {

    @FindBy(css = "[product='HOTELS']")
    private WebElement accommodationLink;

    protected TopBar(WebElement container) {
        super(container);
    }

    public HotelSearch hotels(){
        click(accommodationLink);
        return new HotelSearch();
    }
}
