package anyshchenko.nikita.practice_3_20dataservice.model.location;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Location implements Serializable {
    private Double latitude;
    private Double longitude;
}
