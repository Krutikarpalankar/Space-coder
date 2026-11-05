import axios from "axios";
let api = axios.create({
  baseURL: "http://localhost:8082/api/"
});

export default api;