import React, { Component, useState } from 'react';
import { Container, Row, Col, Button, Stack } from 'react-bootstrap';
import { Navbar, NavItem, NavbarText } from 'reactstrap';


function Footer() {

        return (

            <Container className='mt-5 pt-3'>
                <Row>
                    <div>
                        <Navbar
                            color="secondary"
                            expand
                            fixed='bottom'
                            full
                            dark
                    
                        >
                        <NavbarText  className='ms-5 ps-5 me-auto'>
                            <Button className='btn btn-secondary'>About Us</Button>
                        </NavbarText >
                        <NavbarText >
                            <Button className='btn btn-secondary'>Legal</Button>
                        </NavbarText >
                        <NavbarText  className='me-5 pe-5 ms-auto'>
                            <Button className='btn btn-secondary'>Vendors</Button>
                        </NavbarText >
                        </Navbar>
                    </div>
                </Row>
            </Container>
        )
}

export default Footer;