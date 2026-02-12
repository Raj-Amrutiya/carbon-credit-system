import API from "../api/api";

export const getWalletByUser = (userId) => API.get(`/wallets/user/${userId}`);
export const creditWallet = (data) => API.post("/wallets/credit", data);
export const debitWallet = (data) => API.post("/wallets/debit", data);
