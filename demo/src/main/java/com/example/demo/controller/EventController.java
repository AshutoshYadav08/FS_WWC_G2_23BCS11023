package com.example.demo.controller;

import com.example.demo.model.Event;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/events")
public class EventController {

    private List<Event> events = new ArrayList<>();

    @GetMapping
    public List<Event> getAllEvents() {
        return events;
    }

    @PostMapping
    public String addEvent(@RequestBody Event event) {
        events.add(event);
        return "Event added successfully";
    }
    @GetMapping("/{id}")
    public Event getEvent(@PathVariable int id) {
        for (Event e : events) {
            if (e.getId() == id) {
                return e;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"event not found");
    }
    



    
}


