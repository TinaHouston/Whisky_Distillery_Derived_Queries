package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void findWhiskyByYear(){
		List<Whisky> found = whiskyRepository.findWhiskyByYear(2014);
		assertEquals(4, found.size());
	}

	@Test
	public void findDistilleryByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals(3, found.size());
	}

	@Test
	public void findWhiskyByAgeAndDistillery(){
		String foundDistillery = distilleryRepository.getOne(1L).getName();
		List<Whisky> found = whiskyRepository.findWhiskyByAgeAndDistilleryName(15, foundDistillery);
		assertEquals(1, found.size());
	}

	@Test
	public void findWhiskyByDistilleryRegion(){
		String distilleryRegion = distilleryRepository.getOne(1L).getRegion();
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryRegion(distilleryRegion);
		assertEquals(7, found.size());
	}

	@Test
	public void findDistilleryByWhiskyAge(){
		int whiskyAge = whiskyRepository.getOne(1L).getAge();
		List<Distillery> found = distilleryRepository.getByWhiskiesAge(whiskyAge);
		assertEquals(2, found.size());
	}
}
