package com.flight.schedule.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.schedule.model.Schedule;
import com.flight.schedule.serviceimpl.ScheduleServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ScheduleController {// Annotation
	@Autowired
	private ScheduleServiceImpl scheduleServiceImpl;

	// Save operation
	@PostMapping("/schedule")
	public Schedule saveSchedule(@Valid @RequestBody Schedule schedule) {
		return scheduleServiceImpl.saveSchedule(schedule);
	}

	// Read operation
	@GetMapping("/schedule")
	public List<Schedule> fetchScheduleList() {
		return scheduleServiceImpl.fetchScheduleList();
	}

	// Update operation
	@PutMapping("/schedule/{id}")
	public Schedule updateSchedule(@RequestBody Schedule schedule, @PathVariable("id") Long scheduleId) {
		return scheduleServiceImpl.updateSchedule(schedule, scheduleId);
	}

	// Delete operation
	@DeleteMapping("/schedule/{id}")
	public String deleteScheduleById(@PathVariable("id") Long scheduleId) {
		scheduleServiceImpl.deleteScheduleById(scheduleId);
		return "Deleted Successfully";
	}
}
