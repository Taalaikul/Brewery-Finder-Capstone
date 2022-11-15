package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcReviewDao implements ReviewDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }

        return reviews;
    }

//    public List<Review> reviewsByBeerId(int beer_id){
//        List<Review> reviewsByBeer = new ArrayList<>();
//        String sql = "SELECT * FROM reviews WHERE beer_id =?";
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//
//        while(results.next()){
//            Review reviewByBeer = mapRowToReview(results);
//            reviewByBeer.add()
//        }
//    }

    @Override
    public Review getReviewById(int reviewId) {
        Review review = null;

        String sql = "SELECT * FROM reviews WHERE review_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);
        if(results.next()) {
            review = mapRowToReview(results);
        }
        return review;
    }

    @Override
    public List<Review> getReviewsByBeerId(int beerId) {
        return null;
    }


//    @Override
//    public List<Review> getReviewsByBeerId(int beerId) {
//        List<Review> reviews = new ArrayList<>();
//
//        String sql = "SELECT * FROM reviews " +
//                "JOIN beer_reviews" +
//                " ON reviews.review_id=beer_reviews.review_id " +
//                "WHERE beer_id=?";
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
//        while(results.next()) {
//            Review review = mapRowToReview(results);
//            reviews.add(review);
//        }
//        return reviews;
//    }


    @Override
    public boolean createReview( int stars, String review) {
        boolean reviewCreated = false;

        String insertReview = "INSERT INTO reviews (stars, review) values(?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "review_id";
        reviewCreated = jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(insertReview, new String[]{id_column});
                ps.setInt(1, stars);
                ps.setString(2, review);
                return ps;
            }, keyHolder) == 1;
        int newReviewId = (int) keyHolder.getKeys().get(id_column);

        return reviewCreated;
    }



    @Override
    public boolean deleteReview(int reviewId) {
        String sql = "DELETE FROM reviews WHERE review_id = ?";
        return jdbcTemplate.update(sql, reviewId) == 1;
    }

    @Override
    public boolean updateById(int reviewId, Review updatedReview) {
        String sql = "UPDATE reviews SET stars = ?, review = ? WHERE review_id = ?";
        return jdbcTemplate.update(sql, updatedReview.getStars(), updatedReview.getReview(), reviewId) == 1;
    }

    @Override
    public Double getAvgReview(int beerId) {
        Double avgStars = 0.0;

        String sql = "SELECT AVG (CAST(stars AS DOUBLE)) AS avg_stars FROM reviews WHERE = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
        if(results.next()) {
            avgStars = results.getDouble("avg_stars");

        }
        return avgStars;
    }


    private Review mapRowToReview(SqlRowSet rs) {
        Review review = new Review();
        review.setReviewId(rs.getInt("review_id"));
        review.setStars(rs.getInt("stars"));
        review.setReview(rs.getString("review"));
        return review;

    }
}
