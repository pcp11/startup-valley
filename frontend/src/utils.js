const formatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 0
});

export const formatToUSD = val => {
    return formatter.format(val);
};

