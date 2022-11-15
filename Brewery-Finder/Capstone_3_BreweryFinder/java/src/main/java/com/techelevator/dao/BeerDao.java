package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.User;

import java.util.List;

public interface BeerDao {

    List<Beer> findAll();

    Beer getBeerById(int beerId);

    Beer findByName(String beer_name);

    int findIdByName(String beer_name);

    boolean create(String beer_name, String description, String image, int abv, String type);

    boolean deleteBeer(int beerId);

    boolean updateById(int beerId, Beer updateBeer);

    List<Beer> getBeerByBreweryId(int brewery_id);
}
