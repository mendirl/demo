package com.example.demo;

import io.hypersistence.utils.hibernate.type.array.EnumArrayType;
import io.hypersistence.utils.hibernate.type.array.IntArrayType;
import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import io.hypersistence.utils.hibernate.type.array.internal.AbstractArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import java.util.Arrays;
import java.util.Objects;

@Entity(name = "Event")
@Table(name = "event")
public class Event {

	@Id
	private Long id;

//	private String name;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

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
					value = "sensor_state"
			)
	)
	@Column(
			name = "sensor_states",
			columnDefinition = "events.sensor_state[]"
	)
	private SensorState[] sensorStates;

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
//				&& Objects.equals(name, event.name)
				&& Arrays.equals(sensorNames, event.sensorNames)
				&& Arrays.equals(sensorValues, event.sensorValues)
				&& Arrays.equals(sensorStates, event.sensorStates);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id);
		result = 31 * result + Arrays.hashCode(sensorNames);
		result = 31 * result + Arrays.hashCode(sensorValues);
		result = 31 * result + Arrays.hashCode(sensorStates);
//		result = 31 * result + Objects.hashCode(name);
		return result;
	}
}