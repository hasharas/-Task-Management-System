import { URL } from "../configs/const";
import HttpService from "./HttpService";

class AuthService extends HttpService {
      async login(payload) {
            return this.sendRequest({
                  method: "POST",
                  url: `${URL.BASE_AUTH}/auth/login`,
                  data: payload,
            });
      }
}

const authService = new AuthService();
export default authService;
