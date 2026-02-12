import { useState } from "react";
import API from "../api/api";

export default function Market() {
  const [form, setForm] = useState({ userId: "", credits: "", type: "BUY" });
  const [message, setMessage] = useState("");

  const submit = async () => {
    try {
      await API.post("/market/orders", {
        userId: Number(form.userId),
        credits: Number(form.credits),
        type: form.type
      });
      setMessage("Order placed");
    } catch (err) {
      setMessage("Order failed");
    }
  };

  return (
    <div className="card">
      <h2>Market Order</h2>
      <label>User ID</label>
      <input value={form.userId} onChange={(e) => setForm({ ...form, userId: e.target.value })} />
      <label>Credits</label>
      <input value={form.credits} onChange={(e) => setForm({ ...form, credits: e.target.value })} />
      <label>Type</label>
      <select value={form.type} onChange={(e) => setForm({ ...form, type: e.target.value })}>
        <option value="BUY">BUY</option>
        <option value="SELL">SELL</option>
      </select>
      <div className="row" style={{ marginTop: 12 }}>
        <button onClick={submit}>Place Order</button>
      </div>
      {message && <p>{message}</p>}
    </div>
  );
}
