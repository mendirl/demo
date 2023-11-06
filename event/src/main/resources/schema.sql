drop schema events cascade;

create schema events;

CREATE TYPE events.sensor_state AS ENUM (
    'ONLINE',
    'OFFLINE',
    'UNKNOWN'
    );

CREATE TYPE events.post_status_info AS ENUM (
    'PENDING',
    'APPROVED',
    'SPAM'
    );

CREATE TABLE events.event (
                       id bigint NOT NULL,
                       sensor_names text[],
                       sensor_values integer[],
                       status events.post_status_info,
                       sensor_states events.sensor_state[],
                       CONSTRAINT event_pkey PRIMARY KEY (id)
)