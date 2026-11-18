package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureResponse {
    private Double value;
    private String unit;
    private OffsetDateTime timestamp;
    private String location;
    private String status;
    @JsonProperty("sensor_id")
    private String sensorId;
    @JsonProperty("sensor_type")
    private String sensorType;
    private String description;
}

