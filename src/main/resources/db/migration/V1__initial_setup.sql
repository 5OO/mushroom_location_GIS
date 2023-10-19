CREATE TABLE public.mushroom_location (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(255),
                                       x NUMERIC(19,15) NOT NULL,
                                       y NUMERIC(19,15) NOT NULL,
                                       description TEXT
);
