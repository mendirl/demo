package com.example.demo;

import io.hypersistence.utils.hibernate.type.array.EnumArrayType;
import io.hypersistence.utils.hibernate.type.array.IntArrayType;
import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import io.hypersistence.utils.hibernate.type.array.internal.AbstractArrayType;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import java.util.Arrays;
import java.util.Objects;

@Entity(name = "Event")
@Table(name = "event")
public class Event {

	@Id
	private Long id;

	@Type(StringArrayType.class)
	@Column(
			name = "sensor_names",
			columnDefinition = "text[]"
	)
	private String[] sensorNames;

	@Type(IntArrayType.class)
	@Column(
			name = "sensor_values",
			columnDefinition = "integer[]"
	)
	private int[] sensorValues;

	@Type(
			value = EnumArrayType.class,
			parameters = @Parameter(
					name = AbstractArrayType.SQL_ARRAY_TYPE,
					value = "events.sensor_state"
			)
	)
	@Column(
			name = "sensor_states",
			columnDefinition = "events.sensor_state[]"
	)
	private SensorState[] sensorStates;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "\"events\".\"post_status_info\"")
	@Type(PostgreSQLEnumType.class)
	private PostStatus status;

	public Event() {
	}

	public Long getId() {
		return id;
	}

	public Event setId(Long id) {
		this.id = id;
		return this;
	}

	public String[] getSensorNames() {
		return sensorNames;
	}

	public Event setSensorNames(String[] sensorNames) {
		this.sensorNames = sensorNames;
		return this;
	}

	public int[] getSensorValues() {
		return sensorValues;
	}

	public Event setSensorValues(int[] sensorValues) {
		this.sensorValues = sensorValues;
		return this;
	}

	public SensorState[] getSensorStates() {
		return sensorStates;
	}

	public Event setSensorStates(SensorState[] sensorStates) {
		this.sensorStates = sensorStates;
		return this;
	}

	public PostStatus getStatus() {
		return status;
	}

	public Event setStatus(PostStatus status) {
		this.status = status;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Event event = (Event) o;
		return Objects.equals(id, event.id)
				&& Arrays.equals(sensorNames, event.sensorNames)
				&& Arrays.equals(sensorValues, event.sensorValues)
				&& Arrays.equals(sensorStates, event.sensorStates)
				&& status == event.status;
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, status);
		result = 31 * result + Arrays.hashCode(sensorNames);
		result = 31 * result + Arrays.hashCode(sensorValues);
		result = 31 * result + Arrays.hashCode(sensorStates);
		return result;
	}
}