package api.controller;

import api.dto.TemperatureResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/temperature")
@Slf4j
@Validated
@RequiredArgsConstructor
@CrossOrigin
public class TemperatureController {
    @GetMapping
    public ResponseEntity<TemperatureResponse> getAllSchemes(
            @RequestParam String location
    ) {
        Integer result = ThreadLocalRandom.current().nextInt(-50, 51);

        String sensorId = switch (location) {
            case "Living Room" -> "1";
            case "Bedroom" -> "2";
            case "Kitchen" -> "3";
            default -> "0";
        };

        TemperatureResponse response = TemperatureResponse.builder()
                .location(location)
                .unit("Test unit")
                .value((double) result)
                .description("Описание тестового юнита")
                .sensorId(sensorId)
                .timestamp(OffsetDateTime.now())
                .status("ON")
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{sensorId}")
    public ResponseEntity<TemperatureResponse> getTemperatureBuSensorId(
            @PathVariable String sensorId
    ) {
        Integer result = ThreadLocalRandom.current().nextInt(-50, 51);
          String location = switch (sensorId) {
                case "1" -> "Living Room";
                case "2" -> "Bedroom";
                case "3" -> "Kitchen";
                default -> "Unknown";
            };

        TemperatureResponse response = TemperatureResponse.builder()
                .location(location)
                .unit("Test unit")
                .value((double) result)
                .description("Описание тестового юнита")
                .sensorId(sensorId)
                .timestamp(OffsetDateTime.now())
                .status("ON")
                .build();
        return ResponseEntity.ok(response);
    }
}
