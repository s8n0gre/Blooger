CREATE TABLE users (
    u_id VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    password VARCHAR2(100) NOT NULL,
    age NUMBER,
    gender VARCHAR2(20),
    specialization VARCHAR2(100),
    email VARCHAR2(255)
);

