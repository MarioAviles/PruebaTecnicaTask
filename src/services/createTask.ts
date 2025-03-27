import axios from "axios";

const API_URL = "http://localhost:8080/tasks";

export const createTask = async (task: any) => {
    return await axios.post(API_URL, task);
};