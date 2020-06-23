package anyshchenko.nikita.practice_3_20dataservice.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EventDates implements Serializable {
    private EventDate access;
    private EventDate start;
    private EventDate end;
    private String timezone;
    private Status status;
    private Boolean spanMultipleDays;
}
