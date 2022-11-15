import {Link} from 'react-router-dom'
import Header from '../Subcomponents/Header';
import React, { Component } from 'react';
import Beers from '../Subcomponents/Beers';
import Breweries from '../Subcomponents/Breweries';
import { Container, Row, Col } from 'reactstrap';
import Footer from '../Subcomponents/Footer';

class Home extends Component{
    
    render() {
        return(
            <div>
                <div>
                    <Container className='mt-5 pt-3'>
                        <Row>
                            <Col>
                                <Header/>
                            </Col>
                        </Row>
                        <Row className='mt-5 pt-3'>
                            <Col>
                                <Breweries/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <Footer/>
                            </Col>
                        </Row>
                    </Container>
                </div>
            </div>
        )
    }
}

export default Home;