import React, { Component } from "react";

class HomePage extends Component {
    render() {
        return (
            <div className="card">
                <div className="card-body">
                    <h4 className="card-title"> Welcome to the Online Programming Discussion Forum </h4>
                    <p>This Online Programming Discussion forum is an online community for professional and young developers <br/>
                    to get information related to various programming issues in Java , c , c++ , Javascript, React etc. <br/> 
                    Its a Q & A site where a user has to post , express his problem, and then get comments by professionals <br/>
                    as solution and can directly contact the user who posted the answer to their query.
                    </p>
                </div>
            </div>
        );
    }
}

export default HomePage;