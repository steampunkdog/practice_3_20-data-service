package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;

@Data
public class Classification {
    private Boolean primary;
    private Segment segment;
    private Segment genre;
    private Segment subGenre;
    private Segment type;
    private Segment subType;
    private Boolean family;
}
