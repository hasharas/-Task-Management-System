import axios from 'axios';

//http service to handle API requests
class HttpService {
      constructor() {
            this.service = axios.create();
            this.service.interceptors.request.use((config) => {
                  const token = localStorage.getItem("token");
                  if (token) {
                        config.headers.Authorization = `Bearer ${token}`;
                  }
                  return config;
            });

            this.service.interceptors.response.use(
                  this.handleSuccess,
                  this.handleError
            );
      }

      sendRequest = async (config) => {
            return this.service.request(config);
      };

      handleSuccess = (response) => response?.data;

      handleError = (error) => {
            if (!error.response) {
                  return {
                        success: false,
                        message: "Network error. Please check your internet connection.",
                        data: null,
                  };
            }

            const status = error.response.status;
            if ([401, 403, 404, 408, 419, 429, 500, 501, 502, 503].includes(status)) {
                  window.location.replace(`/${status}`);
            }

            return Promise.reject(error);
      };
}

export default HttpService;
