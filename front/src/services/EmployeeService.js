import { URL } from "../configs/const";
import HttpService from "./HttpService";

// EmployeeService
class EmployeeService extends HttpService {
      async fetchEmployees() {
            return this.sendRequest({
                  method: "GET",
                  url: `${URL.BASE_EMPLOYEE}/employees`,
            });
      }
}

const employeeService = new EmployeeService();
export default employeeService;
