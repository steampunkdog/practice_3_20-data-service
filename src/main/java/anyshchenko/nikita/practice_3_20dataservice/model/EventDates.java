package anyshchenko.nikita.practice_3_20dataservice.model;


import lombok.Data;

@Data
public class EventDates {
    private EventDate access;
    private EventDate start;
    private EventDate end;
    private String timezone;
    private Status status;
    private Boolean spanMultipleDays;
}
