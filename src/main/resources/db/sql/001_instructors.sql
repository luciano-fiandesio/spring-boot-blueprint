CREATE TABLE instructors
(
    instructor_id bigint PRIMARY KEY,
    first_name    VARCHAR(255)        NOT NULL,
    last_name     VARCHAR(255)        NOT NULL,
    email         VARCHAR(255) UNIQUE NOT NULL,
    version       int                 NOT NULL
);
