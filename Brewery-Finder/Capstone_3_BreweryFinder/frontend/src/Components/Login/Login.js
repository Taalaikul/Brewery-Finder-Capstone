import { Component, useState} from 'react'
import {Link} from 'react-router-dom'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'
import {addToken, addUser} from '../../Redux/actionCreators'
import {baseUrl} from '../../Shared/baseUrl'
import axios from 'axios'
import { Container } from 'reactstrap'
import { Stack } from 'react-bootstrap'



const mapDispatchToProps = (dispatch) => ({
    addToken: () =>  dispatch(addToken()),
    addUser: () => dispatch(addUser()) 
});

class Login extends Component {
    
    constructor(props){
        super(props);
        this.state = {
            username: '',
            password: ''
        }
        this.handleInputChange = this.handleInputChange.bind(this);
    }
    

    handleLogin = async () => {
        const data = { username: this.state.username, password: this.state.password };
        

        const userWithToken = await axios.post(baseUrl + '/login', data)

        
        await this.props.dispatch(addToken(userWithToken.data.token))
        await this.props.dispatch(addUser(userWithToken.data.user));
    }

    handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render(){
        return(
            <Container className='mt-5 pt-3'>
                <h1 className='text-center'>Please Sign In</h1>
                <label class="sr-only">Username</label>
                <input
                    type="text"
                    id="username"
                    name="username"
                    class="form-control"
                    placeholder="Username"
                    v-model="user.username"
                    onChange={this.handleInputChange}
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
                    onChange={this.handleInputChange}
                    required
                />
                <Stack direction="horizontal" gap={4} className='mt-3'>
                    <button type="submit" onClick={this.handleLogin} className='btn btn-secondary'>Sign in</button>
                    <Link to="/register" className='btn btn-secondary ms-auto'>New account?</Link>
                    <Link to='/newBrewer' className='btn btn-secondary'>New Brewer?</Link>
                </Stack>
                
            </Container>
        )
    }
}

export default withRouter(connect(mapDispatchToProps)(Login));