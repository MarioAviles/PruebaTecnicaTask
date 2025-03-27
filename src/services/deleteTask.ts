import axios from "axios";

const API_URL = "http://localhost:8080/tasks";

export const deleteTask = async (id: number) => {
    return await axios.delete(`${API_URL}/${id}`);
};