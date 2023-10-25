package com.example.frequency.controllers;

import com.example.frequency.services.FrequencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FrequencyController {
    private FrequencyService frequencyService;

    public FrequencyController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @GetMapping("/api/frequency")
    public ResponseEntity<Map<Character, Integer>> calculateFrequency(@RequestParam String inputString) {
        return ResponseEntity.ok(frequencyService.calculateFrequency(inputString));
    }
}
