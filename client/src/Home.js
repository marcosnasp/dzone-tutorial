import React, { Component } from 'react';
import './App.css';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div className="app">
                {this.props.navbar}
                <Container fluid>
                    {this.props.authenticated ? 
                        <div>
                            <p>Welcome, {this.props.user.name}</p>
                            <Button color="secondary">
                                <Link className="app-link" to="/coffee-shops">
                                    Manage Coffee Shops
                                </Link>
                            </Button>
                        </div> :
                        <div>
                            <p>Please log in to manage coffee shops.</p>
                            <Button color="secondary" disabled={true}>
                                Manage Coffee Shops
                            </Button>
                        </div>
                    }
                </Container>
            </div>
        );
    }
}

export default Home;