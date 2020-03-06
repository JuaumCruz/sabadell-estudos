DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA IF NOT EXISTS order_command AUTHORIZATION sabadell;
CREATE ROLE sabadell_orderc NOSUPERUSER NOCREATEDB NOCREATEROLE NOINHERIT LOGIN PASSWORD 'sabadell_orderc';
GRANT CREATE ON SCHEMA order_command TO sabadell_orderc;
GRANT USAGE ON SCHEMA order_command TO sabadell_orderc;

CREATE SCHEMA IF NOT EXISTS order_query AUTHORIZATION sabadell;
CREATE ROLE sabadell_orderq NOSUPERUSER NOCREATEDB NOCREATEROLE NOINHERIT LOGIN PASSWORD 'sabadell_orderq';
GRANT CREATE ON SCHEMA order_query TO sabadell_orderq;
GRANT USAGE ON SCHEMA order_query TO sabadell_orderq;

CREATE SCHEMA IF NOT EXISTS user_query AUTHORIZATION sabadell;
CREATE ROLE sabadell_userq NOSUPERUSER NOCREATEDB NOCREATEROLE NOINHERIT LOGIN PASSWORD 'sabadell_userq';
GRANT CREATE ON SCHEMA user_query TO sabadell_userq;
GRANT USAGE ON SCHEMA user_query TO sabadell_userq;
