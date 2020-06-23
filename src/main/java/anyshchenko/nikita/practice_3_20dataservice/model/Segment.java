package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Segment implements Serializable {
    private String id;
    private String name;
}
