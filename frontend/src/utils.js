const formatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 0
});

export const formatToUSD = val => {
    return formatter.format(val);
};

export const myFetch = async (url, options = {}) => {
    try {
        const response = await fetch(url, options);
        const data = await response.json();
        return {data: data, error: ""};
    } catch (error) {
        console.log(error);
        return {data: null, error};
    }
};
