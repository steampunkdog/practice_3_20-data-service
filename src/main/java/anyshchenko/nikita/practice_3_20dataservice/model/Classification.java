package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Classification implements Serializable {
    private Boolean primary;
    private Segment segment;
    private Segment genre;
    private Segment subGenre;
    private Segment type;
    private Segment subType;
    private Boolean family;
}
