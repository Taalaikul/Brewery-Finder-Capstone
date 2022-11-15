import axios from 'axios';
import {useState} from 'react'
import { Stack } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import {Link} from 'react-router-dom'
import { Container } from 'reactstrap';
import { baseUrl } from '../../Shared/baseUrl';

const Register = (props) => {

    const redirect = useState(false)
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const handleSubmit = (e) => {
        const data = {username: username, password: password, confirmPassword: confirmPassword, role: 'ROLE_USER'}
        if(password === confirmPassword){
            axios.post(baseUrl + "/register", data)
        }
    }

    return(
        <Container className='mt-5 pt-3 '>
            <h1 className='text-center'>Create Account</h1>
            <label class="sr-only">Username</label>
            <input
                type="text"
                id="username"
                name="username"
                class="form-control"
                placeholder="Username"
                v-model="user.username"
                onChange={(e) => setUsername(e.target.value)}
                required
            />
            <label class="sr-only">Password</label>
            <input
                type="password"
                id="password"
                name="password"
                class="form-control"
                placeholder="Password"
                v-model="user.password"
                onChange={(e) => setPassword(e.target.value)}
                required
            />
            <input
                type="password"
                id="password-confirm"
                name="password-confirm"
                class="form-control"
                placeholder="Confirm Password"
                v-model="user.password"
                onChange={(e) => setConfirmPassword(e.target.value)}
                required
            />
            <Stack className='mt-3' direction='horizontal' >
                <button type="submit" onClick={handleSubmit} className='btn btn-secondary'>Sign Up</button>
                <Link to="/login" className='btn btn-secondary ms-auto'>Already have an account?</Link>
            </Stack>
            
           
            
        </Container>
    )
}

export default Register;