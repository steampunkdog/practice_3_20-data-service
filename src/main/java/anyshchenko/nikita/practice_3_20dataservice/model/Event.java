package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Event extends BaseModel{
    private EventDates dates;

    public List<Venue> getVenues(){
        return getFromEmbedded("venues", Venue.class);
    }

    public List<Attraction> getAttractions(){
        return getFromEmbedded("attraction", Attraction.class);
    }
}
