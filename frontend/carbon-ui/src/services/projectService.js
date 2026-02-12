import API from "../api/api";

export const getProjects = () => API.get("/projects");
export const createProject = (data) => API.post("/projects", data);
