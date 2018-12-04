package com.comunication.fasto.controllers;

import com.comunication.fasto.model.Hotel;
import com.comunication.fasto.repository.hotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/* @CrossOrigin(origins = "http://localhost:8080") */
@RestController
/*@RequestMapping("/api")*/
public class hotelController {
    @Autowired
    hotelRepository repository;

    @GetMapping("/hot")
    public List<Hotel> getAllhotel() {
        System.out.println("get all hotel list ..");
        List<Hotel> hotels = new ArrayList<>();
        repository.findAll().forEach(hotels::add);
        return hotels;
    }
    @PostMapping("/hot/create")
    public Hotel posthotel(@RequestBody Hotel hotel){
        Hotel _hotel = repository.save(new Hotel(hotel.getId(), hotel.getName(), hotel.getNombre()));
        return _hotel;
    }
}
