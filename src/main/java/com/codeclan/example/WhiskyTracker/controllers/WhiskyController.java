package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

//    @GetMapping(value = "/whiskies")
//    public ResponseEntity<List<Whisky>> getAllWhiskies(){
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/whiskies/year")
//    public ResponseEntity<List<Whisky>> getWhiskyByYear(
//        @RequestParam(name = "year") int year){
//            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
//    }
//
//    @GetMapping(value ="/whiskies/age/distillery")
//    public ResponseEntity<List<Whisky>> findWhiskyByDistilleryAndAge(
//            @RequestParam(name = "distillery") String name,
//            @RequestParam(name = "age") int age)
//    {
//        return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, name), HttpStatus.OK);
//    }

//    @GetMapping(value = "/whiskies")
//    public ResponseEntity<List<Whisky>> findWhiskyByDistilleryRegion (
//            @RequestParam(name = "region", required = false) String region, @RequestParam(name="year", required = false, defaultValue = "0") int year,
//            @RequestParam(name = "distillery", required = false) String name, @RequestParam(name="age", required = false, defaultValue = "0") int age){
//        if(name != null & age != 0){
//            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, name), HttpStatus.OK);
//        } else if(year != 0){
//            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
//        } else if(region != null){
//            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
//        } return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByRegionByDistilleryNameAndWhiskyAgeAndByYear (
            @RequestParam(name = "region", required = false) String region,
            @RequestParam(name="year", required = false, defaultValue = "0") int year,
            @RequestParam(name = "distillery", required = false) String name,
            @RequestParam(name="age", required = false, defaultValue = "0") int age) {
        if (year != 0) {
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        } else if (name != null & age != 0){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, name), HttpStatus.OK);
        } else if (region != null){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
        } return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
}




