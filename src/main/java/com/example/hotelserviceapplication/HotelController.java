package com.example.hotelserviceapplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/publish")
    public ResponseEntity<Hotel> publishHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.publishHotel(hotel));
    }

    @GetMapping("list")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{id}/rooms")
    public ResponseEntity<?> getHotelRooms(@PathVariable String id) {
        return hotelService.getHotelById(id)
                .map(hotel -> ResponseEntity.ok(hotel.getRooms()))
                .orElse(ResponseEntity.notFound().build());
    }
}
