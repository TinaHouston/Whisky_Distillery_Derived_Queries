package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

//    @GetMapping(value = "/distilleries")
//    public ResponseEntity<List<Distillery>> getAllDistilleries(){
//        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/distilleries/region")
//    public ResponseEntity<List<Distillery>> getDistilleryByRegion(
//            @RequestParam(name = "region") String region)
//    {
//        return new ResponseEntity<>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
//    }

//    @GetMapping(value="distilleries/whiskies")
//    public ResponseEntity<List<Distillery>> findDistilleriesByWhiskyAge(
//            @RequestParam(name = "age") int age)
//    {
//        return new ResponseEntity<>(distilleryRepository.getByWhiskiesAge(age), HttpStatus.OK);
//    }

    @GetMapping(value="distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleriesByRegionAndByWhiskyAge (
            @RequestParam(name= "region", required = false) String region,
            @RequestParam(name="age", required = false, defaultValue = "0") int age) {
        if(region != null){
            return new ResponseEntity<>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        } else if (age != 0){
            return new ResponseEntity<>(distilleryRepository.getByWhiskiesAge(age), HttpStatus.OK);
        } return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }
}
