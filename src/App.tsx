import React from 'react';
import { BrowserRouter,Route,Routes } from 'react-router-dom';
import { Index } from './component';
import { Register } from './component/register';
import { Login } from './component/login';
import { Dashboard } from './component/userDashboard';
import { Appoinment } from './component/appoinment';
import { Edit } from './component/edit-appoinment';
import { Delete } from './component/delete';
function App() {
  return (
    <div className="container-fluid bg-image">
      <section>
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<Index />} />
        <Route path="register" element={<Register></Register>}></Route>
        <Route path='login' element={<Login />}></Route>
        <Route path='dashboard' element={<Dashboard />}></Route>
        <Route path="appoinment" element={<Appoinment />}></Route>
        <Route path='edit-appointment/:id' element={<Edit></Edit>}></Route>
        <Route path='delete/:id' element={<Delete></Delete>}></Route>
      </Routes>
      </BrowserRouter>
      </section>
    </div>
  );
}

export default App;
