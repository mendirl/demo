package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class CustomersHttpController {

	private final EventRepository eventRepository;
	private final ObjectMapper    objectMapper;

	CustomersHttpController(EventRepository eventRepository, ObjectMapper objectMapper) {
		this.eventRepository = eventRepository;
		this.objectMapper = objectMapper;
	}

	@GetMapping(value = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
	Object event() {
		return eventRepository.findById(1L);
	}

	@PostMapping("event")
	void addEvent() {
		eventRepository.save(
				new Event()
						.setId(1L)
						.setSensorNames(
								new String[]{
										"Temperature",
										"Pressure"
								})
						.setSensorValues(
								new int[]{
										12,
										756
								}
						)
						.setSensorStates(
								new SensorState[]{
										SensorState.ONLINE,
										SensorState.OFFLINE,
										SensorState.ONLINE,
										SensorState.UNKNOWN
								}
						)
		);
	}

	@GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	Object customers() {
		return Set.of(new Customer(1, "A"), new Customer(2, "B"), new Customer(3, "C"));
	}

	record Customer(Integer id, String name) {

	}

}