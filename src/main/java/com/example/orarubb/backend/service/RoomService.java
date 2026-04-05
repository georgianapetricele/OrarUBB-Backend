package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.Room;
import com.example.orarubb.backend.dto.RoomAvailability;
import com.example.orarubb.backend.repository.ClassInstanceRepository;
import com.example.orarubb.backend.repository.DayDefinitionLocaleRepository;
import com.example.orarubb.backend.repository.RoomRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final ClassInstanceRepository classInstanceRepository;
    private final DayDefinitionLocaleRepository dayDefinitionLocaleRepository;

    public RoomService(RoomRepository roomRepository,
                    ClassInstanceRepository classInstanceRepository,
                    DayDefinitionLocaleRepository dayDefinitionLocaleRepository) {
        this.roomRepository = roomRepository;
        this.classInstanceRepository = classInstanceRepository;
        this.dayDefinitionLocaleRepository = dayDefinitionLocaleRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(int roomId) {
        return roomRepository.findById(roomId);
    }

    public List<RoomAvailability> roomAvailability(String language) {
        List<Object[]> results = roomRepository.findRoomAvailabilityByLanguage(language);
        List<RoomAvailability> availableRooms = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (Object[] row : results) {
            try{
                String classDay = (String) row[0];
                String roomsJson = (String) row[1];
                JsonNode rooms = objectMapper.readTree(roomsJson);              
                int startHour = (int) row[2];
                
                RoomAvailability roomAvailability = new RoomAvailability(
                    classDay, 
                    rooms,
                    startHour 
                );
                availableRooms.add(roomAvailability);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return availableRooms;
    }
}
