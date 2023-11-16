CREATE TABLE instructors
(
    id         bigint PRIMARY KEY,
    first_name VARCHAR(255)        NOT NULL,
    last_name  VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_at timestamp           NOT NULL,
    updated_at timestamp           NOT NULL,
    CREATED_BY VARCHAR(255)        NOT NULL,
    UPDATED_BY VARCHAR(255)        NOT NULL,
    VERSION    int                 NOT NULL
);
