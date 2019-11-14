package con.bootcamp.tae.tests.hotel;

import com.bootcamp.tae.testsuite.BaseTestSuite;
import con.bootcamp.tae.pages.common.Home;
import con.bootcamp.tae.pages.hotel.HotelSearchResults;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelSearchTest extends BaseTestSuite {

    private Home home;

    @Before
    public void init() {
        home = new Home();
    }

    @Test
    public void testSearchResults() {
        HotelSearchResults results = home.topBar()
                .hotels()
                .typeDestination("Miami Beach")
                .selectCheckIn()
                .selectCheckOut()
                .selectChildren()
                .search();

        Assert.assertTrue("The total hotel results should be greater than zero.", results.getTotalResults() > 0);

    }

}
