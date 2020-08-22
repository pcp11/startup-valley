import axios from "axios"
import config from "@/config";

const AXIOS = axios.create({
    baseURL: `${config.ENDPOINT}`
});

const formatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 0
});

export const formatToUSD = val => {
    return formatter.format(val);
};

const handleResponse = response => {
    const data = response.data;
    return {data: data, error: ""};
};

const handleError = error => {
    console.log(error);
    return {data: null, error};
};

const get = (url, options) => {
    return AXIOS.get(url, options)
        .then(response => handleResponse(response))
        .catch(error => handleError(error));
}

export const getStartups = async (options = {}) => {
    return get("/startups", options);
};

export const getStartupById = async (id, options = {}) => {
    return get(`/startup/${id}`, options);
};


