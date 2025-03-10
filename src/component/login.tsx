import axios from "axios"
import { useFormik } from "formik"
import React, { useState } from "react"
import { useCookies } from "react-cookie"
import { Link, useNavigate } from "react-router-dom"
import * as yup from "yup";
import 'bootstrap-icons/font/bootstrap-icons.css';
export function Login(){
let navigate = useNavigate()
const[theme,settheme]=useState('border-border-1 p-4')
const[cookie,setcookie,removecookie]=useCookies(['userid'])
const formik = useFormik({
    initialValues:{
        userName:'',
        password:''
          },
          validationSchema:yup.object({userName:yup.string().required("please enter username"),
                               password:yup.string().required("Password required : ")
          }),
    onSubmit:(user) => {
          axios.get(`http://localhost:8082/ToDoListProj/proj-api/all`)
          .then(response => {
            var client =response.data.find((item:any)=>item.userName ==user.userName)
            console.log(client)
            if(client) {
                if(client.password==user.password) 
            {
                setcookie('userid',user.userName)
                 navigate('/dashboard')
            }else{
                alert('INVALID PASSWORD')
            }
    
        }else{
            alert('INVALID USER ID')
        }
    })
    } })

    function HandleTheme(e:any){
 if(e.target.checked){
  settheme('border-border-1 p-4 text-light bg-dark');
 }else{
    settheme('border-border-1 p-4 ');

 }
        
    }

    return(
        <div className="justify-content-center align-items-center d-flex " style={{height:'100vh'}}>
         <form className={`bg-light mt-4 p-3 ${theme}`} onSubmit={formik.handleSubmit}>
            <h3 className="bi bi-person-fill text-warning">Login</h3>
            <dl>
              <div className="form-switch"> 
              <input onChange={HandleTheme} type="checkbox" className="form-check-input"></input><label>Dark Theme</label>
              </div>
                <dt>UserName</dt>
                <dd><input onChange={formik.handleChange} name="userName" type="text" className="form-control"></input></dd>
                <dd className="text-danger">{formik.errors.userName}</dd>
                <dt>PassWord</dt>
                <dd><input onChange={formik.handleChange} name="password" type="password" className="form-control" ></input></dd>
                <dd className="text-danger">{formik.errors.password}</dd>
            </dl>
            <button className="btn btn-warning w-100" type="submit">Login</button>
            <Link className="mt-3 p-2" to="/register">Register</Link>
         </form>
        </div>
    )
}