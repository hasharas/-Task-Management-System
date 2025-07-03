import { useNavigate } from "react-router-dom";
import { logout } from "../auth/useAuth";
import { useEffect, useState } from "react";
import taskService from "../services/TaskService";
import TaskList from "../components/TaskList";
import TaskForm from "../components/TaskForm";
import employeeService from "../services/EmployeeService";

function Dashboard() {
  const navigate = useNavigate();
  const [tasks, setTasks] = useState([]);
  const [editTaskData, setEditTaskData] = useState(null);
  const [employees, setEmployees] = useState([]);

  const fetchTasks = async () => {
    try {
      const data = await taskService.fetchTasks();
      setTasks(data);
    } catch (err) {
      console.error(err);
    }
  };

  const fetchEmployees = async () => {
    try {
      const data = await employeeService.fetchEmployees();
      setEmployees(data);
    } catch (err) {
      console.error(err);
    }
  };

  const handleLogout = () => {
    logout();
    navigate("/");
  };

  useEffect(() => {
    fetchTasks();
    fetchEmployees();
  }, []);

  return (
    <div className="p-4 bg-gray-100 min-h-screen">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-xl font-bold">Task Management</h1>
        <button
          onClick={handleLogout}
          className="bg-red-500 text-white px-4 py-2 rounded"
        >
          Logout
        </button>
      </div>

      <TaskForm
        fetchTasks={fetchTasks}
        editTaskData={editTaskData}
        setEditTaskData={setEditTaskData}
      />

      <TaskList
        tasks={tasks}
        employees={employees}
        fetchTasks={fetchTasks}
        setEditTaskData={setEditTaskData}
      />
    </div>
  );
}

export default Dashboard;
