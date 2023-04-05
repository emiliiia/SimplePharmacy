CREATE TABLE Role (
    id SERIAL PRIMARY KEY,
    roleName VARCHAR(255) NOT NULL
);

INSERT INTO Role (roleName)
VALUES
    ('Admin'),
    ('Manager'),
    ('Developer'),
    ('Customer Support'),
    ('Sales');
