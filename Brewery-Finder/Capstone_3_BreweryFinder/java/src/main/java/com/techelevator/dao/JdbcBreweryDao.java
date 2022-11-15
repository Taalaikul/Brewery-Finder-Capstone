package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Brewery> findAll() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM brewery";

        // "Select * from beer Where ? = ?"

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            breweries.add(mapRowToBrewery(results));
        }

        return breweries;
    }

    @Override
    public Brewery getBreweryById(int brewery_id) {
        Brewery brewery = null;

        String sql = "SELECT * FROM brewery WHERE brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, brewery_id);
        if(results.next()) {
            brewery = mapRowToBrewery(results);
        }

        return brewery;
    }

    @Override
    public Brewery findByName(String brewery_name) {
        for (Brewery brewery : this.findAll()) {
            if( brewery.getBrewery_name().toLowerCase().equals(brewery_name.toLowerCase())) {
                return brewery;
            }
        }
        return null;
    }

    @Override
    public int findBreweryIdByName(String brewery_name) {
        return jdbcTemplate.queryForObject("SELECT brewery_id FROM brewery WHERE brewery_name = ?", int.class, brewery_name);
    }

    @Override
    public boolean create(String brewery_name, String phone_number, String history, String hours_of_operation, String image, String address, String activity) {
        boolean breweryCreated = false;

        String insertBrewery = "INSERT INTO brewery (brewery_name, phone_number, history, hours_of_operation, images, address, activity) values(?,?,?,?,?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "brewery_id";
        breweryCreated = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(insertBrewery, new String[]{id_column});
            ps.setString(1, brewery_name);
            ps.setString(2, phone_number);
            ps.setString(3, history);
            ps.setString(4, hours_of_operation);
            ps.setString(5, image);
            ps.setString(6, address);
            ps.setString(7, activity);
            return ps;
        }, keyHolder) == 1;
        int newBreweryId = (int) keyHolder.getKeys().get(id_column);

        return breweryCreated;
    }

    @Override
    public boolean deleteBrewery(int brewery_id) {
        String sql = "DELETE FROM brewery WHERE brewery_id = ?";
        return jdbcTemplate.update(sql, brewery_id) == 1;
    }

    @Override
    public boolean updateBreweryById(int brewery_id, Brewery updateBrewery) {
        String sql = "UPDATE brewery SET brewery_name = ?, phone_number = ?, history = ?, hours_of_operation = ?, images = ?, address = ?, activity = ?  WHERE brewery_id = ?";
        return jdbcTemplate.update(sql, updateBrewery.getBrewery_id(), updateBrewery.getBrewery_name(), updateBrewery.getPhone_number(), updateBrewery.getHistory(), updateBrewery.getHours_of_operation(), updateBrewery.getImage(), updateBrewery.getAddress(), updateBrewery.getActivity(), brewery_id) == 1;

    }

    private Brewery mapRowToBrewery(SqlRowSet rs) {
        Brewery brewery = new Brewery();
        brewery.setBrewery_id(rs.getInt("brewery_id"));
        brewery.setBrewery_name(rs.getString("brewery_name"));
        brewery.setPhone_number(rs.getString("phone_number"));
        brewery.setHistory(rs.getString("history"));
        brewery.setHours_of_operation(rs.getString("hours_of_operation"));
        brewery.setImage(rs.getString("images"));
        brewery.setAddress(rs.getString("address"));
        brewery.setActivity(rs.getString("activity"));
        return brewery;
    }
}
