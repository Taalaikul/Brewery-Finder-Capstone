package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path="/brewery")
@RestController
@CrossOrigin
public class BreweryController {

    private BreweryDao breweryDao;

    public BreweryController(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Brewery> getBreweries() {
        return breweryDao.findAll();
    }

    @RequestMapping(value = "/id/{brewery_id}", method=RequestMethod.GET)
    public Brewery getBreweryById(@PathVariable int brewery_id){
        return breweryDao.getBreweryById(brewery_id);
    }

    @RequestMapping (value = "/name/{brewery_name)", method=RequestMethod.GET)
        public Brewery getBreweryByName(@PathVariable ("brewery_name") String brewery_name){
        return breweryDao.findByName(brewery_name);
    }
    //works but, ask why in tech squad
    @RequestMapping(method = RequestMethod.POST)
    public Brewery createBrewery(@Valid @RequestBody Brewery brewery){
        breweryDao.create(brewery.getBrewery_name(), brewery.getPhone_number(), brewery.getHistory(), brewery.getHours_of_operation(), brewery.getImage(), brewery.getAddress(), brewery.getActivity());
        return brewery;
    }

    @RequestMapping(path = "/delete/{brewery_id}", method = RequestMethod.DELETE)
    public void deleteBrewery(@PathVariable int brewer_id){
        breweryDao.deleteBrewery(brewer_id);
    }

    @RequestMapping(path = "/update/{brewery_id}", method = RequestMethod.PUT)
    public Brewery updateBreweryById( @Valid @RequestBody Brewery brewery, @PathVariable int brewery_id){
        breweryDao.updateBreweryById(brewery_id, brewery);
        return brewery;
    }

}
