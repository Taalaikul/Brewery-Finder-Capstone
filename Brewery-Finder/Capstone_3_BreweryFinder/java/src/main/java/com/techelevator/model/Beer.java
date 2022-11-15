package com.techelevator.model;

public class Beer {

    private int beer_id;
    private String beer_name;
    private String description;
    private int abv;
    private String image;
    private String type;


    public int getBeer_id() { return beer_id; }

    public void setBeer_id(int beer_id) {
        this.beer_id = beer_id;
    }

    public String getBeer_name() {
        return beer_name;
    }

    public void setBeer_name(String beer_name) {
        this.beer_name = beer_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAbv() { return abv; }

    public void setAbv(int abv) {
        this.abv = abv;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
