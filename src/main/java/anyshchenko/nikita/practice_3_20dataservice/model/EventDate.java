package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class EventDate implements Serializable {
    private LocalDateTime startDateTime;
    private Boolean startApproximate;
    private LocalDateTime endDateTime;
    private Boolean endApproximate;
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime dateTime;
    private Boolean dateTBD;
    private Boolean dateTBA;
    private Boolean timeTBA;
    private Boolean noSpecificTime;
}
