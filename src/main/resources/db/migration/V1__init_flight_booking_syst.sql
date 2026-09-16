CREATE TABLE airport (
                         airport_code CHAR(3) PRIMARY KEY,
                         airport_country VARCHAR(64) NOT NULL,
                         airport_city VARCHAR(128) NOT NULL,
                         timezone VARCHAR(32) NOT NULL
);

CREATE TABLE aircraft (
                          id SERIAL PRIMARY KEY,
                          model VARCHAR(64) NOT NULL UNIQUE,
                          number_of_seats SMALLINT NOT NULL
);

CREATE TABLE seats(
                      aircraft_id INTEGER NOT NULL REFERENCES aircraft ON DELETE CASCADE,
                      seats_no VARCHAR(4) NOT NULL,
                      PRIMARY KEY(aircraft_id, seats_no)
);

CREATE TABLE passenger (
                           id BIGSERIAL PRIMARY KEY,
                           first_name VARCHAR(128) NOT NULL,
                           middle_name VARCHAR(128),
                           last_name VARCHAR(128) NOT NULL,
                           birthday_date DATE NOT NULL,
                           mail VARCHAR(128) NOT NULL UNIQUE,
                           loyalty_card BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE discount (
                          id SERIAL PRIMARY KEY ,
                          discount_status VARCHAR(128) NOT NULL UNIQUE,
                          rate_percent DECIMAL(4, 2) NOT NULL DEFAULT 0.00
);

CREATE TABLE passenger_discount (
                                    passenger_id BIGINT NOT NULL REFERENCES passenger(id) ON DELETE CASCADE,
                                    discount_id INTEGER NOT NULL REFERENCES discount(id) ON DELETE CASCADE,
                                    PRIMARY KEY (passenger_id, discount_id)
);

CREATE TABLE flights (
                         id BIGSERIAL PRIMARY KEY,
                         flight_no VARCHAR(32) NOT NULL,
                         departure_date TIMESTAMP NOT NULL,
                         arrival_date TIMESTAMP NOT NULL,
                         departure_airport_code CHAR(3) NOT NULL REFERENCES airport(airport_code) ON DELETE RESTRICT,
                         arrival_airport_code CHAR(3) NOT NULL REFERENCES airport(airport_code) ON DELETE RESTRICT,
                         status VARCHAR(32) NOT NULL,
                         aircraft_id INTEGER NOT NULL REFERENCES aircraft(id) ON DELETE RESTRICT,
                         version BIGINT NOT NULL DEFAULT 0
);

CREATE TABLE booking (
                         id BIGSERIAL PRIMARY KEY,
                         booking_status VARCHAR(64) NOT NULL,
                         created_at TIMESTAMP NOT NULL DEFAULT now()
);


CREATE TABLE tickets (
                         id BIGSERIAL PRIMARY KEY,
                         price DECIMAL(10, 2) NOT NULL,
                         tickets_no VARCHAR(64) NOT NULL UNIQUE,
                         seat_no VARCHAR(4) NOT NULL,
                         status VARCHAR(32) NOT NULL DEFAULT 'LOCKED',
                         locked_at TIMESTAMP DEFAULT now(),
                         flight_id BIGINT NOT NULL REFERENCES flights(id) ON DELETE CASCADE,
                         passenger_id BIGINT NOT NULL REFERENCES passenger(id) ON DELETE RESTRICT,
                         booking_id BIGINT NOT NULL REFERENCES booking(id) ON DELETE CASCADE,

                         CONSTRAINT uq_flight_seat UNIQUE (flight_id, seat_no)
);