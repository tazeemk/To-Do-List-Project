import axios from "axios"
import { Formik, useFormik } from "formik"
import React from "react"
import { Link, useNavigate } from "react-router-dom"
import * as yup from "yup";
export function Register(){

    let navigate =useNavigate();
    const formik = useFormik({
        initialValues: {
               userId:'',
               userName:'',
               password:'',
               email:'',
               mobile:''  
        },
        validationSchema:yup.object({userName:yup.string().required("Please enter UserName"),password:yup.string().required("Please Enter Password")
            .matches(/^(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/,"Password must Have Min 8 digits 1 captital later And Special Symbol is Required :")
            ,email:yup.string().required("email is required ").email("Invalid Email Format"),
            mobile:yup.string().matches(/^[0-9]{10}$/, "Mobile number must be 10 digits")
        }),
        onSubmit: (user)=>{
         axios.post(`http://localhost:8082/ToDoListProj/proj-api/add-user`,user)
         .then(()=>{
            alert('User registred :')
            navigate('/login')
         })
        }
    })

    return(
        <div className=" d-flex justify-content-center align-items-center">
            <form className="bg-light mt-4 p-3" onSubmit={formik.handleSubmit} noValidate>
                <h2>Register User</h2>
                <dl>
                
                    <dt>User Name</dt>
                    <dd><input onChange={formik.handleChange} name="userName" type="text" className="form-control"></input></dd>
                    <dd>{formik.errors.userName}</dd>
                    <dt>PassWord</dt>
                    <dd><input onChange={formik.handleChange} name="password" type="password" className="form-control"></input></dd>
                    <dd>{formik.errors.password}</dd>
                    <dt>Email</dt>
                    <dd><input onChange={formik.handleChange} name="email" type="email" className="form-control"></input></dd>
                    <dd>{formik.errors.email}</dd>
                    <dt>Mobile Number</dt>
                    <dd><input onChange={formik.handleChange} name="mobile" type="text" className="form-control"></input></dd>
                    <dd>{formik.errors.mobile}</dd>
                </dl>
                <button className="btn btn-primary w-100">Register</button>
                <Link to="/" className="mx-5">Home</Link>
                <Link to="/login">Have Account</Link>
            </form>
        </div>
    )
}