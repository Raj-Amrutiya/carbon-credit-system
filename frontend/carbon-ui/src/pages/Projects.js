import { useState } from "react";
import { createProject } from "../services/projectService";

export default function Projects() {
  const [form, setForm] = useState({ name: "", type: "", co2: "", userId: "" });
  const [message, setMessage] = useState("");

  const submit = async () => {
    try {
      await createProject({
        name: form.name,
        type: form.type,
        co2: Number(form.co2),
        userId: Number(form.userId)
      });
      setMessage("Project created");
    } catch (err) {
      setMessage("Failed to create project");
    }
  };

  return (
    <div className="card">
      <h2>Create Project</h2>
      <label>Project Name</label>
      <input value={form.name} onChange={(e) => setForm({ ...form, name: e.target.value })} />
      <label>Type</label>
      <input value={form.type} onChange={(e) => setForm({ ...form, type: e.target.value })} />
      <label>CO2 Reduced</label>
      <input value={form.co2} onChange={(e) => setForm({ ...form, co2: e.target.value })} />
      <label>User ID</label>
      <input value={form.userId} onChange={(e) => setForm({ ...form, userId: e.target.value })} />
      <div className="row" style={{ marginTop: 12 }}>
        <button onClick={submit}>Save Project</button>
      </div>
      {message && <p>{message}</p>}
    </div>
  );
}
