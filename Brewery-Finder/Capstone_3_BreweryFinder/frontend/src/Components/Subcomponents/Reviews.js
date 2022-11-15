import React from 'react'
import { Component } from 'react/cjs/react.production.min';
import axios from 'axios';
import { Card, CardBody, CardTitle, CardText, Button, Container, Col, CardGroup } from 'reactstrap';
import Scroll from '../Scroll';

class Reviews extends Component {
    
    constructor() {
        super()
        this.state = {
            reviews: [ ]
        }
    }  

    componentDidMount() {
        axios.get('http://localhost:8081/reviews')
            .then(res => {
                console.log(res)
                this.setState({
                    reviews: res.data
                })
            })
    }
    
    render() {
        const { reviews } = this.state;
        const reviewList = reviews.length ? (
            reviews.map(review => {
               return (
                    <Col sm="3">
                    <Card body color="secondary" outline>
                        <CardBody>
                            <CardTitle tag="h3" className='d-flex justify-content-center'>
                                {review.stars}
                            </CardTitle>
                            <CardText className='d-flex justify-content-center'>
                                {review.review}
                            </CardText>
                        </CardBody>
                    </Card>
                </Col>
               ) 
            })
        ) : (
            <div className="center"> 
                <h1>Loading...</h1>
            </div>);
        return(
            <Container>
                <div>
                    <Scroll>
                        <CardGroup>
                            { reviewList }
                        </CardGroup>
                    </Scroll>
                </div>
            </Container>
        )
    }
}

export default Reviews;