import axios from 'axios';
import {useState} from 'react'
import { Stack } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import {Link} from 'react-router-dom'
import { Container } from 'reactstrap';
import { baseUrl } from '../../Shared/baseUrl';

const CreateBrewery = (props) => {

    const [brewery_name, setBrewery_name] = useState("");
    const [phone_number, setPhone_number] = useState("");
    const [history, setHistory] = useState("");
    const [hours_of_operation, setHours_of_operation] = useState("");
    const [image, setImage] = useState("");
    const [address, setAddress] = useState("");
    const [activity, setActivity] = useState("");

    const handleSubmit = () => {
        const data = {brewery_name: brewery_name, phone_number: phone_number, history: history, hours_of_operation: hours_of_operation, image: image, address: address, activity: activity}
        axios.post(baseUrl + "/brewery", data)
        
    }

    return(
        <Container className='mt-5 pt-3'>
            <h1 className='text-center'>Register Brewery</h1>
            <label class="sr-only">Brewery Name</label>
            <input
                type="text"
                id="brewery_name"
                name="brewery_name"
                class="form-control"
                placeholder="Brewery Name"
                v-model="brewery.brewery_name"
                onChange={(e) => setBrewery_name(e.target.value)}
                required
            />
            <label class="sr-only">Phone Number</label>
            <input
                type="tel"
                id="phone_number"
                name="phone_number"
                class="form-control"
                placeholder="Phone Number"
                v-model="brewery.phone_number"
                onChange={(e) => setPhone_number(e.target.value)}
                required
            />
            <label class='sr-only'>History</label>
            <textarea
                type="text"
                id="history"
                name="history"
                class="form-control"
                placeholder="History"
                v-model="brewery.history"
                onChange={(e) => setHistory(e.target.value)}
                required
            />
            <label class='sr-only'>Hours of Operation</label>
            <input
                type="text"
                id="hours_of_operation"
                name="hours_of_operation"
                class="form-control"
                placeholder="Hours of Operation"
                v-model="brewery.hours_of_operation"
                onChange={(e) => setHours_of_operation(e.target.value)}
                required
            />
            <label class='sr-only'>Image</label>
            <input
                type="text"
                id="image"
                name="image"
                class="form-control"
                placeholder="Please use the URL of the image you would like to use"
                v-model="brewery.image"
                onChange={(e) => setImage(e.target.value)}
                required
            />
            <label class='sr-only'>Address</label>
            <input
                type="text"
                id="address"
                name="address"
                class="form-control"
                placeholder="Address"
                v-model="brewery.address"
                onChange={(e) => setAddress(e.target.value)}
                required
            />
            <label class='sr-only'>Activity</label>
            <input
                type="text"
                id="activity"
                name="activity"
                class="form-control"
                placeholder="Activity"
                v-model="brewery.activity"
                onChange={(e) => setActivity(e.target.value)}
                required
            />
            <Stack className='mt-3 d-flex justify-content-center' direction='horizontal'>
                <button type="submit" onClick={handleSubmit} className='btn btn-secondary'>Register Brewery</button>
            </Stack>
            
           
            
        </Container>
    )
}

export default CreateBrewery;