import taskService from "../services/TaskService";

const TaskList = ({
  tasks,
  fetchTasks,
  setEditTaskData,
  employees,
  searchTerm,
  statusFilter,
}) => {

  // Delete task handler
  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this task?")) {
      await taskService.deleteTask(id);
      fetchTasks();
    }
  };
  //get employee name by id
  const getEmployeeName = (id) => {
    const emp = employees.find((e) => e.id === id);
    return emp ? emp.name : "Unknown";
  };

  //  Filter tasks
  const filteredTasks = tasks.filter((task) => {
    const matchesTitle = task.title.toLowerCase().includes(searchTerm.toLowerCase());
    const matchesStatus = statusFilter === "" || task.status === statusFilter;
    return matchesTitle && matchesStatus;
  });

  return (
    <div className="bg-white p-6 rounded-md border border-blue-300 shadow">
      <h2 className="text-xl font-bold mb-3 ">All Tasks</h2>

      <table className="w-full text-sm">
        <thead>
          <tr className="bg-gray-200 border ">
            <th className="p-2 border">Title</th>
            <th className="p-2 border">Status</th>
            <th className="p-2 border">Due Date</th>
            <th className="p-2 border">Assigned Employee</th>
            <th className="p-2 border">Actions</th>
          </tr>
        </thead>
        <tbody>
          {filteredTasks.map((task) => (
            <tr key={task.id}>
              <td className="p-2 border">{task.title}</td>
              <td className="p-2 border">{task.status}</td>
              <td className="p-2 border">{task.dueDate}</td>
              <td className="p-2 border">{getEmployeeName(task.employeeId)}</td>
              <td className="p-2 border space-x-2">
                <button
                  onClick={() => setEditTaskData(task)}
                  className="text-blue-600 border-blue-500 border px-2 py-1 rounded hover:bg-blue-100"
                >
                  Edit
                </button>
                <button
                  onClick={() => handleDelete(task.id)}
                  className="text-red-600 border-red-500 border px-2 py-1 rounded hover:bg-red-100"
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
