import React from "react"

import { Link } from "react-router-dom"
export function Index(){

    return(
        <div className="container-fluid bg-image">
              <h1>hello</h1>
              <div className="justify-content-center align-items-center d-flex" style={{height:'100vh'}}>
                <div>
               <Link to="/register" className="btn btn-warning mx-3">New User Register</Link>
               <Link to="/login" className="btn btn-primary">Existing User Login</Link>
               </div>
              </div>
        </div>
    )
}