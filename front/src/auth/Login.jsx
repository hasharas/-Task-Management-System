import React, { useState } from 'react';

const Login = () => {

      const [userName, setUserName] = useState('');
      const [password, setPassword] = useState('');

      return (
            <div className="min-h-screen flex items-center justify-center bg-gray-100">
                  <form
                        onSubmit=''
                        className="bg-white p-8 rounded-lg shadow-md w-full max-w-sm"
                  >
                        <h2 className="text-2xl font-semibold text-center mb-4">Login</h2>

                        <input
                              type="text"
                              placeholder="Username"
                              value=''
                              onChange=''
                              className="w-full border px-3 py-2 rounded mb-3"
                              required
                        />
                        <input
                              type="password"
                              placeholder="Password"
                              value=''
                              onChange=''
                              className="w-full border px-3 py-2 rounded mb-3"
                              required
                        />

                  </form>
            </div>
      );
}

export default Login;
