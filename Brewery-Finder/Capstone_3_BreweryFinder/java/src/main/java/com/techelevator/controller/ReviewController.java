package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Review;
import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/reviews")
@RestController
@CrossOrigin
public class ReviewController {
    private ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Review> getReviews() {
        return this.reviewDao.findAll();
    }

    @RequestMapping(path = "/id/{reviewId}", method = RequestMethod.GET)
    public Review getReviewById(@PathVariable int reviewId) {
        return this.reviewDao.getReviewById(reviewId);
    }

    @RequestMapping(path="/beer_id/{beerId}", method=RequestMethod.GET)
    public List<Review> getReviewsByBeerId(@PathVariable int beerId){return reviewDao.getReviewsByBeerId(beerId);}

    @RequestMapping(method = RequestMethod.POST)
    public Review createReview(@RequestBody Review review) {
        this.reviewDao.createReview(review.getStars(), review.getReview());
        return review;
    }

    @RequestMapping(path = "/deleteReview/{reviewId}", method = RequestMethod.DELETE)
    public void deleteBeer(@PathVariable int reviewId) {
        this.reviewDao.deleteReview(reviewId);
    }

    @RequestMapping(path = "/updateReview/{reviewId}", method = RequestMethod.PUT)
        public Review updateById(@Valid @RequestBody Review review, @PathVariable int reviewId) {
            this.reviewDao.updateById(reviewId, review);
            return review;
    }

    @RequestMapping(path = "/avgReview/{beerId}", method = RequestMethod.GET)
    public Double getAvgReview(@PathVariable int beerId) {
        return this.reviewDao.getAvgReview(beerId);

    }
}
