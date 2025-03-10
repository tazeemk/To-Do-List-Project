import React, { useEffect } from "react"
import { useCookies } from "react-cookie"
import 'bootstrap-icons/font/bootstrap-icons.css';
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import { Appointment } from "../contracts/appoinment.js";
import axios from "axios";

export function Dashboard(){
const[cookie,setcookie,removecookie]=useCookies(['userid'])
const[appoinmentdata,setappoinmentdata]=useState<Appointment[]>([]);
let navigate =useNavigate()
useEffect(()=>{
    axios.get(`http://localhost:8082/ToDoListProj/proj-api/get-appointment/${cookie['userid']}`)
   .then(response => {
    setappoinmentdata(response.data);
    console.log(appoinmentdata);
   })
},[])
  function handleSignout(){
    removecookie('userid')
    navigate("/login")
  }
  return(
  <div className="p-2">
  <nav className="d-flex justify-content-between mt-4 p-2">
    <div className="h3 text-dark text-warning ">{cookie['userid']} - Dashboard</div>
    <div className="ms-4"><button onClick={handleSignout} className="btn btn-danger">Signout</button></div>
  </nav>
  <section className="text-start" style={{height:'100vh'}}>
     <div>
        <Link to="/appoinment" className="bi bi-calendar-date btn btn-dark"> Add Appointment</Link>
     </div>
     <div>
        {
            appoinmentdata?.map(appointment=>
                <div className="alert w-50 my-4 alert-success" key={appointment.appointment_Id}>
                    <h2>{appointment.title}</h2>
                    <p>{appointment.appointment_Id}</p>
                    <p>{appointment.description}</p>
                    <div className="bi bi-calendar-date"> {appointment.date.toString()} </div>
                    <div className="mt-2">
                        <Link to={`/delete/${appointment.appointment_Id}`} className="bi bi-trash btn btn-danger me-2"> Remove </Link>
                        <Link to={`/edit-appointment/${appointment.appointment_Id}`} className="bi bi-pen-fill btn btn-warning"> Edit </Link>
                    </div>
                </div>

            )
        }
     </div>
  </section>
</div>
  )   
}