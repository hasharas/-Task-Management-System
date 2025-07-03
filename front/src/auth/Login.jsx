import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import authService from '../services/AuthService';

const Login = () => {

      const [username, setUsername] = useState('');
      const [password, setPassword] = useState('');
      const [errorMsg, setErrorMsg] = useState("");
      const navigate = useNavigate();

      const handleLogin = async (e) => {
            e.preventDefault();
            try {
                  const data = await authService.login({ username, password });
                  localStorage.setItem("token", data.token);
                  navigate("/dashboard");
            } catch (err) {
                  setErrorMsg("Invalid username or password");
            }
      };

      return (
            <div className="min-h-screen flex items-center justify-center bg-gray-100">
                  <form
                        onSubmit={handleLogin}
                        className="bg-white p-8 rounded-lg shadow-md w-full max-w-sm"
                  >
                        <h2 className="text-2xl font-semibold text-center mb-4">Login</h2>
                        {/* err msg pring hare  */}
                        {errorMsg && <p className="text-red-600 text-sm mb-3">{errorMsg}</p>}
                        <input
                              type="text"
                              placeholder="Username"
                              value={username}
                              onChange={(e) => setUsername(e.target.value)}
                              className="w-full border px-3 py-2 rounded mb-3"
                              required
                        />
                        <input
                              type="password"
                              placeholder="Password"
                              value={password}
                              onChange={() => setPassword(e.target.value)}
                              className="w-full border px-3 py-2 rounded mb-3"
                              required
                        />

                        <button
                              type="submit"
                              className="bg-blue-500 hover:bg-blue-600 text-white w-full py-2 rounded"
                        >
                              Log In
                        </button>

                  </form>
            </div>
      );
}

export default Login;
