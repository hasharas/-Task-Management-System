import { useEffect, useState } from "react";
import employeeService from "../services/EmployeeService";
import taskService from "../services/TaskService";

const TaskForm = ({ fetchTasks, editTaskData, setEditTaskData }) => {
  const [formData, setFormData] = useState({
    title: "",
    description: "",
    status: "TODO",
    dueDate: "",
    employeeId: "",
  });

  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    if (editTaskData) {
      setFormData(editTaskData);
    }
  }, [editTaskData]);

  useEffect(() => {
    const fetchEmployees = async () => {
      const data = await employeeService.fetchEmployees();
      setEmployees(data);
    };
    fetchEmployees();
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {

    e.preventDefault();
    try {
      if (editTaskData) {
        await taskService.updateTask(editTaskData.id, formData);
        setEditTaskData(null);
      } else {
        await taskService.createTask(formData);
      }

      setFormData({
        title: "",
        description: "",
        status: "TODO",
        dueDate: "",
        employeeId: "",
      });

      alert("Task saved successfully");
      fetchTasks();

    } catch (error) {
      alert("Error while saving task");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="mb-6 bg-white p-4 rounded-md border border-blue-300 shadow">

      <h2 className="text-xl font-semibold mb-2">
        {editTaskData ? "Edit Task" : "Create Task"}
      </h2>

      <input
        type="text"
        name="title"
        placeholder="Title"
        value={formData.title}
        onChange={handleChange}
        required
        className="w-full border p-2 mb-2 rounded"
      />

      <textarea
        name="description"
        placeholder="Description"
        value={formData.description}
        onChange={handleChange}
        required
        className="w-full border p-2 mb-2 rounded"
      />

      <select
        name="status"
        value={formData.status}
        onChange={handleChange}
        className="w-full border p-2 mb-2 rounded"
      >
        <option value="TODO">TODO</option>
        <option value="IN_PROGRESS">IN_PROGRESS</option>
        <option value="DONE">DONE</option>
      </select>

      <input
        type="date"
        name="dueDate"
        value={formData.dueDate}
        onChange={handleChange}
        required
        className="w-full border p-2 mb-2 rounded"
      />

      <select
        name="employeeId"
        value={formData.employeeId}
        onChange={handleChange}
        required
        className="w-full border p-2 mb-2 rounded"
      >
        <option value="">-- Select Employee --</option>
        {employees.map((emp) => (
          <option key={emp.id} value={emp.id}>
            {emp.name}
          </option>
        ))}
      </select>

      <div className="mt-6">
        <button
          type="submit"
          className="bg-blue-500 text-white px-4 py-2 rounded w-full"
        >
          {editTaskData ? "Update Task" : "Add Task"}

        </button>
      </div>
    </form>
  );
};

export default TaskForm;
