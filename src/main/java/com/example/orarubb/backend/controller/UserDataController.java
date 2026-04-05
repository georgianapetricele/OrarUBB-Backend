package com.example.orarubb.backend.controller;

import com.example.orarubb.backend.SupportedLanguages;
import com.example.orarubb.backend.dto.ClassInstanceResponse;
import com.example.orarubb.backend.service.UserClassRelationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserDataController {
    private static final Logger log = LoggerFactory.getLogger(UserDataController.class);

    private final UserClassRelationService userClassRelationService;

    private static final java.util.Set<String> VALID_LANGUAGES = SupportedLanguages.ALL;
    @GetMapping("/classes/{user_id}/{language}")
    public ResponseEntity<List<ClassInstanceResponse>> getClassesForUser(
            @PathVariable("user_id") String userId,
            @PathVariable("language") String language) {

        if (VALID_LANGUAGES.contains(language)) {
            List<ClassInstanceResponse> classes = userClassRelationService.getClassesForUser(userId, language);
            return ResponseEntity.ok(classes);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/classes/{user_id}/{group}")
    public ResponseEntity<String> mapGroupCoursesToUser(
            @PathVariable("user_id") String userId,
            @PathVariable("group") String group
    )
    {
        log.info("Mapping group courses to user: userId={} group={}", userId, group);
        userClassRelationService.mapGroupCoursesToUser(userId, group);
                return ResponseEntity.ok("Group classes mapped to user");
    }
}
