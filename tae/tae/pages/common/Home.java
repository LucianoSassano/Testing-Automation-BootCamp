package con.bootcamp.tae.pages.common;

import com.bootcamp.tae.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends WebPage {

    @FindBy(className = "header-corners-container")
    private WebElement topBarContainer;

    public TopBar topBar(){
        return new TopBar(topBarContainer);
    }

}
