import {Component} from 'react'
import {Switch, Route, Redirect, Link} from 'react-router-dom'
import Login from '../Login/Login'
import Register from '../Register/Register'
import Home from '../Home/Home'
import {addToken, deleteUser} from '../../Redux/actionCreators'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'
import 'reactstrap';
import SiteBrewery from '../Subcomponents/SiteBrewery'
import SiteBeer from '../Subcomponents/SiteBeer'
import NewBrewer from '../Register/NewBrewer'
import { Navbar, NavbarBrand, NavbarText, NavItem } from 'reactstrap'
import CreateBrewery from '../Register/CreateBrewery'

const mapStateToProps = state => {
    return {
        token: state.token,
        user: state.user
    }
}

const mapDispatchToProps = (dispatch) => ({
    addToken: () => { dispatch(addToken()) },
    deleteUser: () => { dispatch(deleteUser())}
});

class Main extends Component {
    constructor(props){
        super(props);
    }

    handleLogout = () => {
        this.props.addToken("")
        this.props.deleteUser()
    }

    render(){
        return(
            <div>
                {this.props.token.token !== undefined ?
                                          
                        <Navbar color="secondary"
                        expand
                        fixed="top"
                        full
                        dark
                        >
                            <NavbarBrand className='me-auto offset-1'>
                                BreweryFinder
                            </NavbarBrand>
                            <NavbarText className='fw-bolder text-white'>
                                <div className='me-4'>
                                    Hello, {this.props.user.username}!
                                </div>
                            </NavbarText>
                            <NavbarText >
                                <Link to='/home' className='btn btn-secondary'>Home </Link>
                            </NavbarText>
                            <NavbarText >
                                <Link to='/login' className='btn btn-secondary me-5 pe-5' onClick={this.handleLogout}>Logout</Link>
                            </NavbarText >
                            
                            <Redirect to='/home'/>
                        </Navbar>  
                    : 
                    <Navbar color="secondary"
                    expand
                    fixed="top"
                    full
                    dark
                    >
                        <NavbarBrand className='me-auto offset-1'>
                            BreweryFinder
                        </NavbarBrand>
                        <NavItem>
                            <Link to='/login' className='btn btn-secondary me-5 pe-5'>Home </Link>
                        </NavItem>
                    </Navbar>
                }
                <Switch>
                    <Route path='/login' component={() => <Login/>}/>
                    <Route path='/register'component={() => <Register/>}/>
                    <Route path='/newBrewer' component={() => <NewBrewer/>}/>
                    <Route path='/createBrewery' component={() => <CreateBrewery/>}/>
                    <Route path='/home' component={this.props.token.token !== undefined ? () => <Home/> : null}/>
                    <Route path='/SiteBrewery/:breweryId' component={this.props.token.token !== undefined ? () => <SiteBrewery/> : null}/>
                    <Route path='/SiteBeer' component={this.props.token.token !== undefined ? () => <SiteBeer/> : null}/>
                    <Redirect to='/login'/>
                </Switch>
            </div>
        )
    }
} 

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));