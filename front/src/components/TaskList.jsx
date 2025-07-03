import taskService from "../services/TaskService";

const TaskList = ({ tasks, fetchTasks, setEditTaskData, employees }) => {

  //delete function
  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this task?")) {
      await taskService.deleteTask(id);
      fetchTasks();
    }
  };


  //  get employee name by ID
  const getEmployeeName = (id) => {
    const emp = employees.find((e) => e.id === id);
    return emp ? emp.name : "Unknown";
  };

  return (
    <div className="bg-white p-4 rounded shadow">
      <h2 className="text-lg font-semibold mb-2">All Tasks</h2>

      <table className="w-full border border-blue-500 text-sm">
        <thead>
          <tr className="bg-gray-200 border-blue-500">
            <th className="p-2 border">Title</th>
            <th className="p-2 border">Status</th>
            <th className="p-2 border">Due Date</th>
            <th className="p-2 border">Assigned Employee</th>
            <th className="p-2 border">Actions</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => (
            <tr key={task.id}>
              <td className="p-2 border">{task.title}</td>
              <td className="p-2 border">{task.status}</td>
              <td className="p-2 border">{task.dueDate}</td>
              <td className="p-2 border">{getEmployeeName(task.employeeId)}</td>
              <td className="p-2 border space-x-2">
                <button
                  onClick={() => setEditTaskData(task)}
                  className="text-blue-600"
                >
                  Edit
                </button>
                <button
                  onClick={() => handleDelete(task.id)}
                  className="text-red-600"
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TaskList;
