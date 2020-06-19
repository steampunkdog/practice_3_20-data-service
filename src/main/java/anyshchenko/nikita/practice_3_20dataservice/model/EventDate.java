package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class EventDate {
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
