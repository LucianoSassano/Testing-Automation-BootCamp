package con.bootcamp.tae.pages.common.calendar;

import com.bootcamp.tae.page.web.WebComponent;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class CalendarContainer extends WebComponent {

    //TODO: @FindBy
    private WebElement calendarLeftContainer;

    //TODO: @FindBy
    private WebElement calendarRightContainer;

    //TODO: @FindBy
    private WebElement nextMonth;

    public CalendarContainer(WebElement container) {
        super(container);
    }

    public CalendarContainer selectCheckIn(int months, int day) {
        selectMonth(months).selectDay(day);
        return this;
    }

    public CalendarContainer selectCheckOut(int months, int day) {
        selectMonth(months).selectDay(day);
        return this;
    }

    private Calendar selectMonth(int months) {
        if (months == 0) {
            return new Calendar(calendarLeftContainer);
        }

        if (months == 1) {
            return new Calendar(calendarRightContainer);
        }

        if (months > 1) {
            while (months > 1) {
                click(nextMonth);
                months--;
            }
            return new Calendar(calendarLeftContainer);
        }

        throw new RuntimeException(format("Unable to pick a valid month, using '%d' as 'months'.", months));
    }

}
