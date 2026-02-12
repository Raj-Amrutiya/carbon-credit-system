INSERT INTO users (name, email, password, role) VALUES
('Admin', 'admin@ccms.local', 'admin123', 'ADMIN');

INSERT INTO wallets (user_id, balance) VALUES
(1, 1000.0);

INSERT INTO projects (name, type, co2, user_id) VALUES
('Solar Farm', 'Renewable', 120.5, 1),
('Reforestation', 'Nature', 300.0, 1);

INSERT INTO orders (user_id, credits, type) VALUES
(1, 50.0, 'BUY');
