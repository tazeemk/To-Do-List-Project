import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { Appointment } from "../contracts/appoinment";
import { useFormik } from "formik";
import { useCookies } from "react-cookie";
import axios from "axios";

export function Edit() {
  const [appoinmentdata, setappoinmentdata] = useState<Appointment | null>(null); // Initialize as null
  const { id } = useParams();
  const [cookie] = useCookies(['userid']);
  let navigate = useNavigate();

  // Fetch the appointment data using useEffect
  useEffect(() => {
    axios.get(`http://localhost:8082/ToDoListProj/proj-api/getId/${id}`)
      .then(response => {
        setappoinmentdata(response.data); // Set appointment data once fetched
      })
      .catch(error => {
        console.error("Error fetching appointment:", error);
      });
  }, [id]);

  // Ensure that Formik initializes only after the data has been fetched
  const formik = useFormik({
    enableReinitialize: true,  // Reinitialize Formik when data changes
    initialValues: appoinmentdata ? {
      appointment_Id:appoinmentdata.appointment_Id,
      title: appoinmentdata.title,
      description: appoinmentdata.description,
      date: appoinmentdata.date.slice(0, 10), // Format date as 'YYYY-MM-DD'
      userName: cookie['userid']
    } : {
      appointment_Id:0,
      title: '',
      description: '',
      date: '',
      userName: cookie['userid']
    },
    onSubmit: (values) => {
      axios.put(`http://localhost:8082/ToDoListProj/proj-api/update-appoint`, values)
        .then(() => {
          alert('Appointment Edited Successfully');
          navigate('/dashboard');
        })
        .catch((error) => {
          console.error("Error updating appointment:", error);
        });
    }
  });

  // Wait for appoinmentdata to be fetched before rendering the form
  if (!appoinmentdata) {
    return <div>Loading...</div>;  // Display loading until appointment data is fetched
  }

  return (
    <div className="justify-content-center align-items-center d-flex">
      <form className="bg-light mt-4 p-3" onSubmit={formik.handleSubmit}>
        <h3>Edit Appointment</h3>
        <dl>
            <dt>Appointment Id</dt>
            <dd><input type="number" className="form-control" name="appointment_Id" value={formik.values.appointment_Id} onChange={formik.handleChange} readOnly></input></dd>
          <dt>Title</dt>
          <dd>
            <input
              type="text"
              className="form-control"
              name="title"
              onChange={formik.handleChange}
              value={formik.values.title}
            />
          </dd>
          <dt>Description</dt>
          <dd>
            <textarea
              rows={4}
              cols={40}
              className="form-control"
              onChange={formik.handleChange}
              name="description"
              value={formik.values.description}
            />
          </dd>
          <dt>Date</dt>
          <dd>
            <input
              type="date"
              className="form-control"
              name="date"
              onChange={formik.handleChange}
              value={formik.values.date}  // Use formatted date value
            />
          </dd>
        </dl>
        <button className="btn btn-success">Save</button>
        <Link to="/dashboard" className="btn btn-primary mx-2">Cancel</Link>
      </form>
    </div>
  );
}
