package com.example.docker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class ThemeParkRideController {
    private final ThemeParkRideRepository themeParkRideRepository;
    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }
    @GetMapping(value = "/ride")
    public Iterable<ThemeParkRide> getRides() {
        return themeParkRideRepository.findAll();
    }
    @GetMapping(value = "/ride/{id}")
    public ThemeParkRide getRide(@PathVariable long id){
        return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }
    @PostMapping(value = "/ride")
    public ThemeParkRide createRide( @RequestBody ThemeParkRide themeParkRide) {
        return themeParkRideRepository.save(themeParkRide);
    }
    @GetMapping(value = "/ride/findByName/{name}")
    public Iterable<ThemeParkRide> findByName(@PathVariable("name") String name) {
        return themeParkRideRepository.findByName(name);
    }
}
