import { URL } from "../configs/const";
import HttpService from "./HttpService";

// TaskService
class TaskService extends HttpService {
      async fetchTasks() {
            return this.sendRequest({
                  method: "GET",
                  url: `${URL.BASE_TASK}/tasks`,
            });
      }

      async fetchTaskById(id) {
            return this.sendRequest({
                  method: "GET",
                  url: `${URL.BASE_TASK}/tasks/${id}`,
            });
      }

      async createTask(task) {
            return this.sendRequest({
                  method: "POST",
                  url: `${URL.BASE_TASK}/tasks`,
                  data: task,
            });
      }

      async updateTask(id, task) {
            return this.sendRequest({
                  method: "PUT",
                  url: `${URL.BASE_TASK}/tasks/${id}`,
                  data: task,
            });
      }

      async deleteTask(id) {
            return this.sendRequest({
                  method: "DELETE",
                  url: `${URL.BASE_TASK}/tasks/${id}`,
            });
      }
}

const taskService = new TaskService();
export default taskService;
