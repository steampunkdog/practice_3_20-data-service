package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public abstract class BaseModel {
    private String name;
    private String type;
    private String id;
    private Boolean test;
    private String url;
    private String locale;
    private Collection<Image> images;
    private Collection<Classification> classifications;
    private Map<String, List<BaseModel>> _embedded;

    public <T extends BaseModel> List<T> getFromEmbedded(String fieldName, Class<T> clazz){
        return _embedded.get(fieldName).stream().map(clazz::cast).collect(Collectors.toList());
    }
}
