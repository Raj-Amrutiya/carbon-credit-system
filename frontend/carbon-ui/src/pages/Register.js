import { useState } from "react";
import { register } from "../services/authService";

export default function Register() {
  const [form, setForm] = useState({ name: "", email: "", password: "" });
  const [message, setMessage] = useState("");

  const submit = async () => {
    try {
      await register({ ...form, role: "USER" });
      setMessage("Registration successful");
    } catch (err) {
      setMessage("Registration failed");
    }
  };

  return (
    <div className="card">
      <h2>Register</h2>
      <label>Name</label>
      <input value={form.name} onChange={(e) => setForm({ ...form, name: e.target.value })} />
      <label>Email</label>
      <input value={form.email} onChange={(e) => setForm({ ...form, email: e.target.value })} />
      <label>Password</label>
      <input type="password" value={form.password} onChange={(e) => setForm({ ...form, password: e.target.value })} />
      <div className="row" style={{ marginTop: 12 }}>
        <button onClick={submit}>Create Account</button>
      </div>
      {message && <p>{message}</p>}
    </div>
  );
}
