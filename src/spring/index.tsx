import React, { useEffect, useState } from "react"
import { Emp } from "./emp"
import axios from "axios"



export function Index(){
   const[data,setdata]=useState({tid:0,tname:'',taddr:'',mobileno:0,dob:''})
       
   useEffect(() =>{
    axios.get('http://localhost:8081/BootRestProj10-RestAPI-TouristAPI-MiniProject/tour-API/showone/104')
   .then(response=>{
    setdata(response.data)
    console.log(response.data)
   })  
},[])
    return(
        <div className="align-items-center d-flex">
           <h3>Welcome</h3>
           <div>
            
                
                   <dl>
                    <dt>id</dt>
                    <dd>{data.tid}</dd>
                    <dt>Name</dt>
                    <dd>{data.tname}</dd>
                   </dl>
                
            
           </div>

        </div>
    )
}