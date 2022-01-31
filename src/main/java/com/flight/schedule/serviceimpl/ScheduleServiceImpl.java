package com.flight.schedule.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.schedule.model.Schedule;
import com.flight.schedule.repository.ScheduleRepository;
import com.flight.schedule.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public List<Schedule> fetchScheduleList() {
		return scheduleRepository.findAll();
	}

	@Override
	public Schedule updateSchedule(Schedule schedule, Long scheduleId) {

		Schedule scheduleDB = scheduleRepository.findById(scheduleId).get();

		if (Objects.nonNull(schedule.getAirportId())) {
			scheduleDB.setAirportId(schedule.getAirportId());
		}
		if (Objects.nonNull(schedule.getFlightId())) {
			scheduleDB.setFlightId(schedule.getFlightId());
		}

		if (Objects.nonNull(schedule.getArraivalTime()) && !"".equalsIgnoreCase(schedule.getArraivalTime())) {
			scheduleDB.setArraivalTime(schedule.getArraivalTime());
		}
		if (Objects.nonNull(schedule.getDepartureTime()) && !"".equalsIgnoreCase(schedule.getDepartureTime())) {
			scheduleDB.setDepartureTime(schedule.getDepartureTime());
		}

		return scheduleRepository.save(scheduleDB);
	}

	@Override
	public void deleteScheduleById(Long scheduleId) {
		scheduleRepository.deleteById(scheduleId);

	}
}
