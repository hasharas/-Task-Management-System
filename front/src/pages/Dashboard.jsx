import { useNavigate } from "react-router-dom";
import { logout } from "../auth/useAuth";
import { useEffect, useState } from "react";
import taskService from "../services/TaskService";
import TaskList from "../components/TaskList";
import TaskForm from "../components/TaskForm";

function Dashboard() {
  const navigate = useNavigate();
  const [tasks, setTasks] = useState([]);
  const [editTaskData, setEditTaskData] = useState(null);

  const fetchTasks = async () => {
  try {
    const data = await taskService.fetchTasks();
    setTasks(Array.isArray(data) ? data : []);
  } catch (err) {
    console.error("Failed to fetch tasks", err);
    setTasks([]); 
  }
};

  const handleLogout = () => {
    logout();
    navigate("/");
  };

  useEffect(() => {
    fetchTasks();
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
        fetchTasks={fetchTasks}
        setEditTaskData={setEditTaskData}
      />
    </div>
  );
}

export default Dashboard;
