package con.bootcamp.tae.pages.common.calendar;

import com.bootcamp.tae.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Calendar extends WebComponent {

    //TODO: @FindBy
    private WebElement title;

    //TODO: @FindBy
    private WebElement daysHeader;

    @FindBy(css = "._dpmg2--date._dpmg2--available")
    private List<WebElement> activeDays;

    protected Calendar(WebElement container) {
        super(container);
    }

    public Calendar selectFirstAvailableDay() {
        click(activeDays.stream()
                .filter(day -> day.getAttribute("class").contains("_dpmg2--today"))
                .findFirst()
                .get()
        );
        return this;
    }

    public Calendar selectDay(int day) {
        // TODO: Select day from the available days to pick.
        return this;
    }


}
