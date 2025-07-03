import { useState } from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import './App.css'
import Login from './pages/Login';
import { isLoggedIn } from './auth/useAuth';
import Dashboard from './pages/Dashboard';


const PrivateRoute = ({ children }) => {
  return isLoggedIn() ? children : <Navigate to="/" />;
};


function App() {

  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route
            path="/dashboard"
            element={
              <PrivateRoute>
                <Dashboard />
              </PrivateRoute>
            }
          />
        </Routes>
      </Router>
    </>
  )
}

export default App
