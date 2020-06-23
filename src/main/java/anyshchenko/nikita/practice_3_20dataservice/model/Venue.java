package anyshchenko.nikita.practice_3_20dataservice.model;

import anyshchenko.nikita.practice_3_20dataservice.model.location.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Venue extends BaseModel{
    private String postalCode;
    private String timezone;
    private City city;
    private State state;
    private Country country;
    private Address address;
    private Location location;
}
