package com.example.orarubb.backend.controller;

import com.example.orarubb.backend.SupportedLanguages;
import com.example.orarubb.backend.domain.Room;
import com.example.orarubb.backend.dto.RoomAvailability;
import com.example.orarubb.backend.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    private static final java.util.Set<String> VALID_LANGUAGES = SupportedLanguages.ALL;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms-schedule/{language}")
    public ResponseEntity<List<RoomAvailability>> getRoomSchedule(@PathVariable("language") String language) {
        if (VALID_LANGUAGES.contains(language)) {
            List<RoomAvailability> roomsSchedule = roomService.roomAvailability(language);
            return ResponseEntity.ok(roomsSchedule);
        }

        return ResponseEntity.badRequest().build();
    }
    
}
