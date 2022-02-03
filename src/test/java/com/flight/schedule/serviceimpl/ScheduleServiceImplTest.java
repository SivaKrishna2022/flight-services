package com.flight.schedule.serviceimpl;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.flight.schedule.model.Schedule;
import com.flight.schedule.repository.ScheduleRepository;

class ScheduleServiceImplTest {
	@InjectMocks
	private ScheduleServiceImpl scheduleServiceImpl = new ScheduleServiceImpl();
	@Mock
	private ScheduleRepository scheduleRepository = Mockito.mock(ScheduleRepository.class);

	@BeforeEach
	public void setUp() {
		ReflectionTestUtils.setField(scheduleServiceImpl, "scheduleRepository", scheduleRepository);
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveSchedule() {
		ReflectionTestUtils.setField(scheduleServiceImpl, "scheduleRepository", scheduleRepository);
		Mockito.when(scheduleRepository.save(Mockito.any())).thenReturn(new Schedule());
		scheduleServiceImpl.saveSchedule(new Schedule());
	}

	@Test
	void testFetchScheduleList() {
		Mockito.when(scheduleRepository.findAll()).thenReturn(Arrays.asList(new Schedule()));
		scheduleServiceImpl.fetchScheduleList();
	}

	@Test
	void testUpdateSchedule() {
		Mockito.when(scheduleRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Schedule()));
		Mockito.when(scheduleRepository.save(Mockito.any())).thenReturn(new Schedule());
		scheduleServiceImpl.updateSchedule(new Schedule(), 1L);
	}

	@Test
	void testDeleteScheduleById() {
		scheduleServiceImpl.deleteScheduleById(1L);
	}

}
