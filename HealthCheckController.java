package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {
  
  private static final String STATUS_OK = "OK";
  private static final String FORMAT_SHORT = "format-short";
  private static final String FORMAT_FULL = "format-full";
  
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> getHealthCheck(@RequestParam(required = false) String format) {
    if (format == null || format.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    if (FORMAT_SHORT.equals(format)) {
      return ResponseEntity.ok(Collections.singletonMap("status", STATUS_OK));
    } else if (FORMAT_FULL.equals(format)) {
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
      String formattedDate = now.format(formatter);
      Map<String, String> responseMap = Map.of("status", STATUS_OK, "currentTime", formattedDate);
      return ResponseEntity.ok(responseMap);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
