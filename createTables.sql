DROP TABLE IF EXISTS roles, manufacturer, users, drug, orders;

CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    roleName VARCHAR(255) NOT NULL
);

CREATE TABLE manufacturer (
      id SERIAL PRIMARY KEY,
      manufacturer_name VARCHAR(255) NOT NULL UNIQUE,
      country VARCHAR(255) NOT NULL,
      agent_name VARCHAR(255) NOT NULL,
      agent_phone_num VARCHAR(255) NOT NULL UNIQUE,
      description TEXT,
      created_at DATE DEFAULT now(),
      updated_at DATE DEFAULT now()
);

CREATE TABLE users (
       id SERIAL PRIMARY KEY,
       user_name VARCHAR(255) NOT NULL,
       user_date_birth DATE NOT NULL,
       user_phone_num VARCHAR(20) UNIQUE,
       user_email VARCHAR(255) UNIQUE,
       role_id INTEGER REFERENCES roles(id) NOT NULL,
       created_at DATE DEFAULT now(),
       updated_at DATE DEFAULT now()
);

CREATE TABLE drug (
      id SERIAL PRIMARY KEY,
      drug_name VARCHAR(255) NOT NULL,
      expiration_date DATE NOT NULL,
      volume DOUBLE PRECISION,
      price DOUBLE PRECISION NOT NULL,
      in_stock INTEGER NOT NULL,
      manufacturer_id INTEGER REFERENCES manufacturer(id) NOT NULL,
      description TEXT,
      created_at DATE DEFAULT now(),
      updated_at DATE DEFAULT now()
);

CREATE TABLE orders (
       id SERIAL PRIMARY KEY,
       client_id INTEGER REFERENCES users(id) NOT NULL,
       drug_id INTEGER REFERENCES drug(id) NOT NULL,
       drug_quantity INTEGER NOT NULL,
       price DOUBLE PRECISION NOT NULL,
       order_status VARCHAR(255) NOT NULL,
       order_go BOOLEAN DEFAULT FALSE,
       created_at DATE DEFAULT now(),
       updated_at DATE DEFAULT now()
);