--psql -U postgres:	access root account postgres
CREATE USER estatespring122018 WITH PASSWORD '123456';
CREATE DATABASE estatespring122018 OWNER estate ENCODING = 'UTF8';
--psql -U estate -d estate (pass: 123456)
CREATE SCHEMA estatespring122018;