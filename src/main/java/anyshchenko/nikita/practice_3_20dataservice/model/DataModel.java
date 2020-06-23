package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class DataModel implements Serializable {
    private Map<String, List<Event>> _embedded;
    //TODO create links and page
}