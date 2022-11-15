package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {

    List<Brewery> findAll();

    Brewery getBreweryById(int brewery_id);

    Brewery findByName(String brewery_name);

    int findBreweryIdByName(String brewery_name);

    boolean create(String brewery_name, String phone_number, String history, String hours_of_operation, String image, String address, String activity);

    boolean deleteBrewery (int brewery_id);

    boolean updateBreweryById(int brewery_id, Brewery updateBrewery);
}
