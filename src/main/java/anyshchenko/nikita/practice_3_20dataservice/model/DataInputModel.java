package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DataInputModel {
    private Map<String, List<Event>> _embedded;
    //TODO create links and page

}
