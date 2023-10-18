CREATE TABLE mushroom_location (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(255),
                                       x NUMERIC(10,6) NOT NULL,
                                       y NUMERIC(10,6) NOT NULL,
                                       description TEXT
);
