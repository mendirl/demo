CREATE TYPE sensor_state AS ENUM (
    'ONLINE',
    'OFFLINE',
    'UNKNOWN'
);

CREATE TABLE event (
                       id bigint NOT NULL,
                       sensor_names text[],
                       sensor_values integer[],
                       sensor_states sensor_state[],
                       CONSTRAINT event_pkey PRIMARY KEY (id)
)