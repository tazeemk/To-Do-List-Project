import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { Appointment } from "../contracts/appoinment";
import { useCookies } from "react-cookie";
import axios from "axios";

export function Delete() {
  const [appointment, setAppointment] = useState<Appointment | null>(null);
  const { id } = useParams(); // Get the appointment ID from the URL parameters
  const [cookie] = useCookies(['userid']);
  let navigate = useNavigate();

  useEffect(() => {
    // Fetch appointment data using the provided ID
    axios.get(`http://localhost:8082/ToDoListProj/proj-api/getId/${id}`)
      .then(response => {
        setAppointment(response.data);
      })
      .catch(error => {
        console.error('Error fetching appointment:', error);
      });
  }, [id]);

  // Handle delete action
  function HandleDelete() {
    axios.delete(`http://localhost:8082/ToDoListProj/proj-api/remove/${id}`)
      .then(() => {
        alert('Appointment deleted successfully');
        navigate('/dashboard'); // Navigate to the dashboard after deletion
      })
      .catch(error => {
        console.error('Error deleting appointment:', error);
      });
  }

  if (!appointment) {
    return <div>Loading...</div>; // Show loading state if appointment data is not yet fetched
  }

  return (
    <div className="p-2">
      <nav className="d-flex justify-content-between mt-4 p-2">
        {/* Add any nav items here if needed */}
      </nav>
      <section className="text-start" style={{ height: '100vh' }}>
        <div>
          <div className="alert w-50 my-4 alert-danger">
            <h2>Delete Appointment</h2>
            <h3>{appointment.title}</h3>
            <p><strong>ID:</strong> {appointment.appointment_Id}</p>
            <p><strong>Description:</strong> {appointment.description}</p>
            <div><strong>Date:</strong> {appointment.date.toString()}</div>
            <div className="mt-2">
              {/* Yes button triggers the delete */}
              <button onClick={HandleDelete} className="btn btn-danger mx-2">Yes</button>
              {/* No button navigates back to the dashboard */}
              <Link to="/dashboard" className="btn btn-warning">No</Link>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}
