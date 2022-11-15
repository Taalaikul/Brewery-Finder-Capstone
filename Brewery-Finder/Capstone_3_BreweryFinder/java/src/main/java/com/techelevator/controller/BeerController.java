package com.techelevator.controller;

import com.techelevator.model.Beer;

import com.techelevator.dao.BeerDao;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/beers")
@RestController
@CrossOrigin
public class BeerController {
    private BeerDao beerDao;

    public BeerController(BeerDao beerDao) {
        this.beerDao = beerDao;
        }


    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Beer> getBeers() {
        return this.beerDao.findAll();
    }

    @RequestMapping(value = "/id/{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable int beerId) {
        return beerDao.getBeerById(beerId);
    }

    @RequestMapping(value="/brewery_id/{brewery_id}", method= RequestMethod.GET)
    public List<Beer> getBeerByBreweryId(@PathVariable int brewery_id){return this.beerDao.getBeerByBreweryId(brewery_id);}

    @RequestMapping(value = "/name/{beerName}", method = RequestMethod.GET)
    public Beer getBeersByName(@PathVariable ("beerName") String beerName) {
        return beerDao.findByName(beerName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Beer createBeer(@Valid @RequestBody Beer beer) {
        beerDao.create(beer.getBeer_name(), beer.getDescription(), beer.getImage(), beer.getAbv(), beer.getType());
        return beer;
    }

    @RequestMapping(path = "/delete/{beerId}", method = RequestMethod.DELETE)
    public void deleteBeer(@PathVariable int beerId) {

        beerDao.deleteBeer(beerId);
    }

    @RequestMapping(path = "/update/{beerId}", method = RequestMethod.PUT)
    public Beer updateById(@Valid @RequestBody Beer beer, @PathVariable int beerId) {
        beerDao.updateById(beerId, beer);
        return beer;
    }

}

/*
  @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Auction update(@Valid @RequestBody Auction auction, @PathVariable int id) throws AuctionNotFoundException {
        this.dao.update(auction, id);
        return auction;
    }
 */

