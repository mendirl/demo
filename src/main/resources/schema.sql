create schema events;

CREATE TYPE events.sensor_state AS ENUM (
    'ONLINE',
    'OFFLINE',
    'UNKNOWN'
    );

CREATE TABLE events.event (
                       id bigint NOT NULL,
                       sensor_names text[],
                       sensor_values integer[],
                       sensor_states events.sensor_state[],
                       CONSTRAINT event_pkey PRIMARY KEY (id)
)