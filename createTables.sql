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

CREATE TABLE manufacturer (
      id SERIAL PRIMARY KEY,
      manufacturer_name VARCHAR(255),
      country VARCHAR(255),
      agent_name VARCHAR(255),
      agent_phone_num VARCHAR(255),
      description TEXT,
      created_at DATE DEFAULT now(),
      updated_at DATE DEFAULT now()
);
