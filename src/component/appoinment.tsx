import axios from "axios";
import { useFormik } from "formik"
import React from "react"
import { useCookies } from "react-cookie"
import { Link, useNavigate } from "react-router-dom"

export function Appoinment(){
  const[cookie,setcookie,removecookie] =useCookies(['userid']);
  let navigate =useNavigate()
    const formik =useFormik({
        initialValues:{
              title:'',
              description:'',
              date:'',
              userName:cookie['userid']
        },onSubmit:(user) => {
           axios.post('http://localhost:8082/ToDoListProj/proj-api/add-appointment',user)
            .then(response => {
            alert("Appointment Added successfully")
            navigate("/dashboard")
            console.log(user)
            });
        }
    })
    return(
        <div className="text-start d-flex justify-content-center">
          <form className="bg-light p-3 mt-4" onSubmit={formik.handleSubmit}>
           <h2>Add New Appoinmnet</h2>
           <dl>
               <dt>Title</dt>
            <dd><input type="text" className="form-control" name="title" onChange={formik.handleChange}></input></dd>
           <dt>Description</dt>
           <dd><textarea rows={4} cols={40} name="description" className="form-control" onChange={formik.handleChange} /></dd>
           <dt>Date</dt>
           <dd><input type="date" name="date" className="form-control" onChange={formik.handleChange}></input></dd>
           </dl>
           <button className="btn btn-primary w-100" type="submit">Add</button>
           <div className="mt-2">
           <Link to="/dashboard" > Return To DaskBoard :</Link>
           </div>
           </form>
           </div>
    )
}