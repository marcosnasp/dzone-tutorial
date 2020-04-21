import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CoffeeShopsList from './CoffeeShopsList';
import CoffeeShopEdit from './CoffeeShopEdit';
import NavBar from './NavBar';
import Api from './Api';

const api = new Api();

class App extends Component {
  render() {
    const navbar = <NavBar />;
    return (
      <Router>
        <Switch>
          <Route 
            path='/'
            exact={true}
            render={(props) => <Home {...props} api={api} navbar={navbar} />} 
          />
          <Route
            path='/coffee-shops'
            exact={true}
            render={(props) => <CoffeeShopsList {...props} api={api} navbar={navbar} />} 
          />
          <Route 
            path='/coffee-shops/:id'
            render={(props) => <CoffeeShopEdit {...props} api={api} navbar={navbar} />} 
          />    
        </Switch>
      </Router>
    );
  }
}

export default App;