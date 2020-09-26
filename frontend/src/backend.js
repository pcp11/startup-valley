import axios from "axios"
import config from "@/config";

const AXIOS = axios.create({
    baseURL: `${config.ENDPOINT}`
});

const handleResponse = response => {
    const data = response.data;
    return {data: data, error: null};
};

const handleError = error => {
    console.log(error);
    return {data: null, error};
};

const get = (url, options) => {
    return AXIOS.get(url, options)
        .then(response => handleResponse(response))
        .catch(error => handleError(error));
};

const post = (url, data, options) => {
    return AXIOS.post(url, data, options)
        .then(response => handleResponse(response))
        .catch(error => handleError(error));
};

export const getStartups = async (options = {}) => {
    return get("/startups", options);
};

export const getStartupById = async (id, options = {}) => {
    return get(`/startup/${id}`, options);
};

export const login = async (username, password, options = {}) => {
    return post("/auth/login", {name: username, password: password}, options);
};

export const register = async (username, password, options = {}) => {
    return post("/auth/signup", {name: username, password: password}, options);
};

export const getSecureKey = async (options = {}) => {
    return get("/secured", options);
};