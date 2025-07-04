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
  const [searchTerm, setSearchTerm] = useState("");
  const [statusFilter, setStatusFilter] = useState("");

  //fetch tasks
  const fetchTasks = async () => {
    try {
      const data = await taskService.fetchTasks();
      setTasks(data);
    } catch (err) {
      console.error(err);
    }
  };

  //fetch employee
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
    // alert("You have been logged out successfully.");
    navigate("/");
  };

  //task and employee data fetch on component mount
  useEffect(() => {
    fetchTasks();
    fetchEmployees();
  }, []);

  return (
    <div className="p-6 bg-gray-200 rounded-md min-h-screen">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold">Task Management</h1>
        <button
          onClick={handleLogout}
          className="bg-red-500 hover:bg-red-600 text-white px-4 py-2 rounded"
        >
          Logout
        </button>
      </div>

      <TaskForm
        fetchTasks={fetchTasks}
        editTaskData={editTaskData}
        setEditTaskData={setEditTaskData}
      />

      <div className="mb-4 flex flex-wrap items-center gap-4">
        <input
          type="text"
          placeholder="Search by title..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="border border-blue-300 px-3 py-2 rounded w-64"
        />
        <select
          value={statusFilter}
          onChange={(e) => setStatusFilter(e.target.value)}
          className="border border-blue-300 bg-white px-6 py-2 rounded"
        >
          <option value="">All Statuses</option>
          <option value="TODO">TODO</option>
          <option value="IN_PROGRESS">IN_PROGRESS</option>
          <option value="DONE">DONE</option>
        </select>
      </div>

      <TaskList
        tasks={tasks}
        employees={employees}
        fetchTasks={fetchTasks}
        setEditTaskData={setEditTaskData}
        searchTerm={searchTerm}
        statusFilter={statusFilter}
      />
    </div>
  );
}

export default Dashboard;
