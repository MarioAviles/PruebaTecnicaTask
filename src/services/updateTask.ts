import axios from "axios";

const API_URL = "http://localhost:8080/tasks";

export const updateTask = async (id: number, task: any) => {
    return await axios.put(`${API_URL}/${id}`, task);
};