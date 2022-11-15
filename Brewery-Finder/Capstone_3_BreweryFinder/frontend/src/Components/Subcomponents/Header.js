import React, { Component, useState } from 'react';
import { Container, Row, Col, Button, Stack } from 'react-bootstrap';


function Header() {

        return (

            <Container className='mt-5 pt-3'>
                <Row>
                    <Col>
                        <Stack direction="horizontal" gap={4}>
                            <h1 className='fw-bolder offset-1'>Welcome!</h1>
                        </Stack>
                    </Col>
                </Row>
            </Container>
        )
}

export default Header;