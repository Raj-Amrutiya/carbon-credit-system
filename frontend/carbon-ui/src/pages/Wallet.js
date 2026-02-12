import { useState } from "react";
import { creditWallet, debitWallet } from "../services/walletService";

export default function Wallet() {
  const [userId, setUserId] = useState("");
  const [amount, setAmount] = useState("");
  const [message, setMessage] = useState("");

  const credit = async () => {
    try {
      await creditWallet({ userId: Number(userId), amount: Number(amount) });
      setMessage("Wallet credited");
    } catch (err) {
      setMessage("Credit failed");
    }
  };

  const debit = async () => {
    try {
      await debitWallet({ userId: Number(userId), amount: Number(amount) });
      setMessage("Wallet debited");
    } catch (err) {
      setMessage("Debit failed");
    }
  };

  return (
    <div className="card">
      <h2>Wallet</h2>
      <label>User ID</label>
      <input value={userId} onChange={(e) => setUserId(e.target.value)} />
      <label>Amount</label>
      <input value={amount} onChange={(e) => setAmount(e.target.value)} />
      <div className="row" style={{ marginTop: 12 }}>
        <button onClick={credit}>Credit</button>
        <button className="secondary" onClick={debit}>Debit</button>
      </div>
      {message && <p>{message}</p>}
    </div>
  );
}
