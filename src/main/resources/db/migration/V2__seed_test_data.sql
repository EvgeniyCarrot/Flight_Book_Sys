INSERT INTO airport (airport_code, airport_country, airport_city, timezone) VALUES
                                                                                ('SVO', 'Russia', 'Moscow', 'Europe/Moscow'),
                                                                                ('VKO', 'Russia', 'Moscow', 'Europe/Moscow'),
                                                                                ('DME', 'Russia', 'Moscow', 'Europe/Moscow'),
                                                                                ('LED', 'Russia', 'Saint Petersburg', 'Europe/Moscow'),
                                                                                ('KJA', 'Russia', 'Krasnoyarsk', 'Asia/Krasnoyarsk'),
                                                                                ('OVB', 'Russia', 'Novosibirsk', 'Asia/Novosibirsk'),
                                                                                ('SVX', 'Russia', 'Yekaterinburg', 'Asia/Yekaterinburg'),
                                                                                ('KGD', 'Russia', 'Kaliningrad', 'Europe/Kaliningrad'),
                                                                                ('ROV', 'Russia', 'Rostov-on-Don', 'Europe/Moscow'),
                                                                                ('KZN', 'Russia', 'Kazan', 'Europe/Moscow'),
                                                                                ('AER', 'Russia', 'Sochi', 'Europe/Moscow'),
                                                                                ('UFA', 'Russia', 'Ufa', 'Asia/Yekaterinburg'),
                                                                                ('PMV', 'Venezuela', 'Porlamar', 'America/Caracas'),
                                                                                ('JFK', 'USA', 'New York', 'America/New_York'),
                                                                                ('LHR', 'United Kingdom', 'London', 'Europe/London');
INSERT INTO aircraft (model, number_of_seats) VALUES
                                                  ('Boeing 737-800', 189),
                                                  ('Airbus A320-200', 180),
                                                  ('Boeing 777-300ER', 396),
                                                  ('Airbus A350-900', 325),
                                                  ('Boeing 747-400', 416),
                                                  ('Sukhoi Superjet 100', 103),
                                                  ('Airbus A321-200', 220),
                                                  ('Boeing 787-9 Dreamliner', 290),
                                                  ('Embraer E190', 114),
                                                  ('Airbus A330-300', 335),
                                                  ('Boeing 767-300ER', 269),
                                                  ('Airbus A319-100', 156),
                                                  ('Boeing 737 MAX 8', 210),
                                                  ('Airbus A380-800', 525),
                                                  ('Bombardier CRJ900', 90);
INSERT INTO passenger (first_name, middle_name, last_name, birthday_date, mail, loyalty_card) VALUES
                                                                                                  ('Иван', 'Иванович', 'Иванов', '1985-03-15', 'ivanov@example.com', TRUE),
                                                                                                  ('Мария', 'Петровна', 'Смирнова', '1990-07-22', 'smirnova@example.com', FALSE),
                                                                                                  ('Александр', 'Сергеевич', 'Кузнецов', '1978-11-08', 'kuznetsov@example.com', TRUE),
                                                                                                  ('Елена', 'Андреевна', 'Попова', '1995-01-30', 'popova@example.com', FALSE),
                                                                                                  ('Дмитрий', 'Владимирович', 'Волков', '1982-09-12', 'volkov@example.com', TRUE),
                                                                                                  ('Анна', 'Михайловна', 'Соколова', '1988-05-25', 'sokolova@example.com', FALSE),
                                                                                                  ('Сергей', 'Николаевич', 'Лебедев', '1975-12-03', 'lebedev@example.com', TRUE),
                                                                                                  ('Ольга', 'Дмитриевна', 'Козлова', '1992-04-18', 'kozlova@example.com', FALSE),
                                                                                                  ('Андрей', 'Александрович', 'Новиков', '1980-08-07', 'novikov@example.com', TRUE),
                                                                                                  ('Татьяна', 'Игоревна', 'Морозова', '1987-02-14', 'morozova@example.com', FALSE),
                                                                                                  ('Михаил', 'Павлович', 'Петров', '1993-10-29', 'petrov@example.com', TRUE),
                                                                                                  ('Наталья', 'Викторовна', 'Васильева', '1986-06-11', 'vasileva@example.com', FALSE),
                                                                                                  ('Владимир', 'Олегович', 'Зайцев', '1979-03-26', 'zaitsev@example.com', TRUE),
                                                                                                  ('Екатерина', 'Романовна', 'Павлова', '1991-11-19', 'pavlova@example.com', FALSE),
                                                                                                  ('Николай', 'Геннадьевич', 'Семенов', '1984-07-05', 'semenov@example.com', TRUE);
INSERT INTO discount (discount_status, rate_percent) VALUES
                                                         ('STUDENT', 15.00),
                                                         ('SENIOR', 10.00),
                                                         ('MILITARY', 20.00),
                                                         ('DISABLED', 25.00),
                                                         ('LOYALTY_BRONZE', 5.00),
                                                         ('LOYALTY_SILVER', 10.00),
                                                         ('LOYALTY_GOLD', 15.00),
                                                         ('LOYALTY_PLATINUM', 20.00),
                                                         ('EARLY_BIRD', 12.00),
                                                         ('LAST_MINUTE', 8.00),
                                                         ('GROUP_10', 7.00),
                                                         ('GROUP_20', 12.00),
                                                         ('CORPORATE', 18.00),
                                                         ('CHILD', 30.00),
                                                         ('INFANT', 90.00);
INSERT INTO flights (flight_no, departure_date, arrival_date, departure_airport_code, arrival_airport_code, status, aircraft_id, version) VALUES
                                                                                                                                              ('SU-1001', '2026-10-15 08:00:00', '2026-10-15 10:30:00', 'SVO', 'LED', 'SCHEDULED', 1, 0),
                                                                                                                                              ('SU-1002', '2026-10-15 14:00:00', '2026-10-15 16:45:00', 'LED', 'SVO', 'SCHEDULED', 2, 0),
                                                                                                                                              ('SU-2001', '2026-10-16 09:30:00', '2026-10-16 18:00:00', 'SVO', 'JFK', 'SCHEDULED', 3, 0),
                                                                                                                                              ('SU-2002', '2026-10-16 20:00:00', '2026-10-17 06:30:00', 'JFK', 'SVO', 'SCHEDULED', 3, 0),
                                                                                                                                              ('SU-3001', '2026-10-17 07:15:00', '2026-10-17 09:45:00', 'VKO', 'KGD', 'SCHEDULED', 4, 0),
                                                                                                                                              ('SU-3002', '2026-10-17 11:00:00', '2026-10-17 13:30:00', 'KGD', 'VKO', 'SCHEDULED', 4, 0),
                                                                                                                                              ('SU-4001', '2026-10-18 06:00:00', '2026-10-18 12:00:00', 'DME', 'OVB', 'DEPARTED', 5, 1),
                                                                                                                                              ('SU-4002', '2026-10-18 13:00:00', '2026-10-18 19:00:00', 'OVB', 'DME', 'ARRIVED', 5, 2),
                                                                                                                                              ('SU-5001', '2026-10-19 10:00:00', '2026-10-19 12:30:00', 'SVX', 'KZN', 'CANCELLED', 6, 3),
                                                                                                                                              ('SU-5002', '2026-10-19 15:00:00', '2026-10-19 17:30:00', 'KZN', 'SVX', 'SCHEDULED', 6, 0),
                                                                                                                                              ('SU-6001', '2026-10-20 08:30:00', '2026-10-20 11:00:00', 'ROV', 'AER', 'SCHEDULED', 7, 0),
                                                                                                                                              ('SU-6002', '2026-10-20 12:00:00', '2026-10-20 14:30:00', 'AER', 'ROV', 'SCHEDULED', 7, 0),
                                                                                                                                              ('SU-7001', '2026-10-21 09:00:00', '2026-10-21 11:30:00', 'UFA', 'KJA', 'DELAYED', 8, 1),
                                                                                                                                              ('SU-7002', '2026-10-21 14:00:00', '2026-10-21 16:30:00', 'KJA', 'UFA', 'SCHEDULED', 8, 0),
                                                                                                                                              ('SU-8001', '2026-10-22 07:00:00', '2026-10-22 19:00:00', 'SVO', 'LHR', 'SCHEDULED', 9, 0);
INSERT INTO booking (booking_status, created_at) VALUES
                                                     ('PAID', '2026-10-01 10:15:00'),
                                                     ('PENDING', '2026-10-02 14:30:00'),
                                                     ('CONFIRMED', '2026-10-03 09:00:00'),
                                                     ('PAID', '2026-10-04 16:45:00'),
                                                     ('CANCELLED', '2026-10-05 11:20:00'),
                                                     ('COMPLETED', '2026-10-06 08:00:00'),
                                                     ('PAID', '2026-10-07 13:10:00'),
                                                     ('PENDING', '2026-10-08 17:25:00'),
                                                     ('CONFIRMED', '2026-10-09 10:50:00'),
                                                     ('PAID', '2026-10-10 15:35:00'),
                                                     ('COMPLETED', '2026-10-11 09:40:00'),
                                                     ('PAID', '2026-10-12 12:05:00'),
                                                     ('CANCELLED', '2026-10-13 14:15:00'),
                                                     ('CONFIRMED', '2026-10-14 11:30:00'),
                                                     ('PAID', '2026-10-15 08:20:00');
INSERT INTO tickets (price, tickets_no, seat_no, status, locked_at, flight_id, passenger_id, booking_id) VALUES
                                                                                                             (12500.00, 'TKT-2026-001', '12A', 'PAID', '2026-10-01 10:15:00', 1, 1, 1),
                                                                                                             (12500.00, 'TKT-2026-002', '12B', 'PAID', '2026-10-01 10:16:00', 1, 2, 1),
                                                                                                             (45000.00, 'TKT-2026-003', '5F', 'CONFIRMED', '2026-10-03 09:00:00', 3, 3, 3),
                                                                                                             (45000.00, 'TKT-2026-004', '5G', 'CONFIRMED', '2026-10-03 09:01:00', 3, 4, 3),
                                                                                                             (8500.00, 'TKT-2026-005', '3C', 'LOCKED', '2026-10-04 16:45:00', 5, 5, 4),
                                                                                                             (8500.00, 'TKT-2026-006', '3D', 'PAID', '2026-10-04 16:46:00', 5, 6, 4),
                                                                                                             (18000.00, 'TKT-2026-007', '10A', 'USED', '2026-10-06 08:00:00', 7, 7, 6),
                                                                                                             (18000.00, 'TKT-2026-008', '10B', 'USED', '2026-10-06 08:01:00', 7, 8, 6),
                                                                                                             (9500.00, 'TKT-2026-009', '7E', 'CANCELLED', '2026-10-09 10:50:00', 9, 9, 9),
                                                                                                             (9500.00, 'TKT-2026-010', '7F', 'PAID', '2026-10-10 15:35:00', 10, 10, 10),
                                                                                                             (11000.00, 'TKT-2026-011', '15A', 'CONFIRMED', '2026-10-11 09:40:00', 11, 11, 11),
                                                                                                             (11000.00, 'TKT-2026-012', '15B', 'PAID', '2026-10-12 12:05:00', 11, 12, 12),
                                                                                                             (7500.00, 'TKT-2026-013', '2D', 'LOCKED', '2026-10-13 14:15:00', 13, 13, 13),
                                                                                                             (7500.00, 'TKT-2026-014', '2E', 'CONFIRMED', '2026-10-14 11:30:00', 13, 14, 14),
                                                                                                             (52000.00, 'TKT-2026-015', '20A', 'PAID', '2026-10-15 08:20:00', 15, 15, 15);
INSERT INTO seats (aircraft_id, seats_no) VALUES
                                              (1, '1A'),
                                              (1, '1B'),
                                              (1, '1C'),
                                              (2, '2A'),
                                              (2, '2B'),
                                              (2, '2C'),
                                              (3, '5F'),
                                              (3, '5G'),
                                              (3, '5H'),
                                              (4, '3C'),
                                              (4, '3D'),
                                              (5, '10A'),
                                              (5, '10B'),
                                              (6, '7E'),
                                              (6, '7F');

INSERT INTO passenger_discount (passenger_id, discount_id) VALUES
                                                               (1, 5),   -- Иванов: LOYALTY_BRONZE
                                                               (2, 1),   -- Смирнова: STUDENT
                                                               (3, 7),   -- Кузнецов: LOYALTY_GOLD
                                                               (4, 14),  -- Попова: CHILD
                                                               (5, 6),   -- Волков: LOYALTY_SILVER
                                                               (6, 2),   -- Соколова: SENIOR
                                                               (7, 8),   -- Лебедев: LOYALTY_PLATINUM
                                                               (8, 9),   -- Козлова: EARLY_BIRD
                                                               (9, 13),  -- Новиков: CORPORATE
                                                               (10, 10), -- Морозова: LAST_MINUTE
                                                               (11, 3),  -- Петров: MILITARY
                                                               (12, 11), -- Васильева: GROUP_10
                                                               (13, 4),  -- Зайцев: DISABLED
                                                               (14, 12), -- Павлова: GROUP_20
                                                               (15, 15); -- Семенов: INFANT