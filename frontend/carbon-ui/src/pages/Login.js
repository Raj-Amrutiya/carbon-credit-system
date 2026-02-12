import { useState } from "react";
import { login } from "../services/authService";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const submit = async () => {
    try {
      const res = await login({ email, password });
      setMessage(`Welcome ${res.data.name || "user"}`);
    } catch (err) {
      setMessage("Invalid credentials");
    }
  };

  return (
    <div className="card">
      <h2>Login</h2>
      <label>Email</label>
      <input value={email} onChange={(e) => setEmail(e.target.value)} />
      <label>Password</label>
      <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
      <div className="row" style={{ marginTop: 12 }}>
        <button onClick={submit}>Login</button>
      </div>
      {message && <p>{message}</p>}
    </div>
  );
}
