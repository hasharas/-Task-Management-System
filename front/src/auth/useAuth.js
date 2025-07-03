
//check if user log in or not
export const isLoggedIn = () => {
      return !!localStorage.getItem("token");
};

export const logout = () => {
      localStorage.removeItem("token");
      window.location.href = "/";
};
