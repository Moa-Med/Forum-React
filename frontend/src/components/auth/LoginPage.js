import React, { Component } from "react";
import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";
import Auth from "../../services/Auth";

class LoginPage extends Component {
    async login(loginData) {
        const loginSuccess = await Auth.login(loginData);
        if (!loginSuccess) {
            alert("Invalid credentials");
        }
    }

    async register(registrationData) {
        const registerSuccess = await Auth.register(registrationData);
        if (!registerSuccess) {
            alert("Couldn't register check credentials and try again");
        }
    }

    render() {
        return (
            <div className="wrapper-login">
                <div className="container">
                    <div className="row mt-4">
                        <div className="col-md-6"> 
                            <div className="card-body-login">
                             <p><img src={require(`../../assets/logo.png`)} width={254} height={254} alt='Logo' /></p>
                             <p className="p-login">WELCOME <br/>to the Online Programming Discussion Forum</p>
                            </div>
                        </div>
                        <div className="col-md-6">
                            <div className="row">
                                <div className="col-12  strong-shadow">
                                    <LoginForm onSubmit={this.login} />
                                </div>

                                <div className="col-12 mt-4">
                                    <RegisterForm onSubmit={this.register}/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default LoginPage;