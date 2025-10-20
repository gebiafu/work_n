-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(64) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ
);

-- Seed admin user (password = "password")
INSERT INTO users (username, password, role, enabled)
VALUES ('admin', '$2a$10$7EqJtq98hPqEX7fNZaFWoO5/8NQ8A5HgD8qjNqQs6TWlE4p0/5h2a', 'ADMIN', TRUE)
ON CONFLICT (username) DO NOTHING;
