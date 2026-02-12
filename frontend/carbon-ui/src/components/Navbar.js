import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <nav className="navbar">
      <div><strong>CCMS</strong></div>
      <div>
        <Link to="/">Login</Link>
        <Link to="/register">Register</Link>
        <Link to="/dashboard">Dashboard</Link>
        <Link to="/projects">Projects</Link>
        <Link to="/wallet">Wallet</Link>
        <Link to="/market">Market</Link>
      </div>
    </nav>
  );
}
