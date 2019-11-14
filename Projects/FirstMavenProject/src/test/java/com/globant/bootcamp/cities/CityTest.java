package com.globant.bootcamp.cities;

import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.junit.runners.Suite;

public class CityTest  {

    private CityManager cityManager=new CityManager();



    @BeforeClass
    public void addCities(){
        cityManager.addCity("7600","Mar del Plata");
        cityManager.addCity("1000","Buenos Aires");
        cityManager.addCity("7000","Tandil");
    }

    @AfterClass
    public void clearCities(){
        cityManager.clear();
    }

    @DataProvider(name="cityProvider")
    public Object[][] cities(){
        return new Object[][]{{"7600","Mar del Plata"},{"1000","Buenos Aires"},
        {"7000","Tandil"}

        };

    }

    @Test(dataProvider = "cityProvider")
    public void testCitybyZipCode(String zip,String city){
        Assert.assertEquals(cityManager.getCityByZip(zip).get(),city);
        System.out.println();

    }



}
