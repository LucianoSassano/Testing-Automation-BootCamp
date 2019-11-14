package com.globant.bootcamp.cities;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class CityManager {

    private Map<String, String> cities = new HashMap<String, String>();

    public void addCity(String zip, String city) {
        cities.put(zip, city);
    }

    public Optional<String> getCityByZip(String zip) {

        if (zip != null && cities.containsKey(zip)) {
            return Optional.of(cities.get(zip));
        }
        System.out.println("Codigo de area no encontrado");
        return Optional.empty();

    }

    public void clear() {
        cities.clear();
    }


}