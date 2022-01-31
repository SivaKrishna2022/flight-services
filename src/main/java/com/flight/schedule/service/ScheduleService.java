package com.flight.schedule.service;

import java.util.List;

import com.flight.schedule.model.Schedule;

public interface ScheduleService {

	// Save operation
	Schedule saveSchedule(Schedule schedule);

	// Read operation
	List<Schedule> fetchScheduleList();

	// Update operation
	Schedule updateSchedule(Schedule schedule, Long scheduleId);

	// Delete operation
	void deleteScheduleById(Long schedule);

}
