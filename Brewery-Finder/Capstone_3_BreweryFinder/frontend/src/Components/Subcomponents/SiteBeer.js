import React from 'react'
import { Component } from 'react/cjs/react.production.min';
import {Container, Col, Row} from 'reactstrap';
import Reviews from './Reviews';
import Header from './Header';
import Footer from './Footer';

class SiteBeer extends Component { 
    constructor(props) {
        super(props)
        this.state = {
            beerId: this.props.beerId,
        }
    } 
    //lets try yt video, sending id to site brewery,
    //from site brewery to beers
    // componentDidMount () {
    //     const { handle } = this.props.match.params

       
    //     console.log( fetch(`http://localhost:8081/beers/brewery_id/${handle}`))

    // }


    render() {
        return(
            <Container className='mt-5 pt-3'>
                <Row>
                    <Col>
                        <Header/>
                    </Col>
                </Row>
                <Row className='mt-5 pt-3'>
                    <Col>
                        <Reviews/>
                    </Col>
                </Row>
                <Row className='mt-5 pt-3'>
                    <Col>
                        <Footer/>
                    </Col>
                </Row>
            </Container>
        )
    }
}

export default SiteBeer;