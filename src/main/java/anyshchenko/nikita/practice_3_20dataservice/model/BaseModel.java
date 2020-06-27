package anyshchenko.nikita.practice_3_20dataservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Attraction.class, name = Types.ATTRACTION),
        @JsonSubTypes.Type(value = Event.class, name = Types.EVENT),
        @JsonSubTypes.Type(value = Venue.class, name = Types.VENUE)
})
@Data
@NoArgsConstructor
public abstract class BaseModel implements Serializable {
    protected String name;
    protected String type;
    protected String id;
    protected Boolean test;
    protected String url;
    protected String description;
    protected String locale;
    protected Collection<Image> images;
    protected Collection<Classification> classifications;
    protected Map<String, List<? extends BaseModel>> _embedded;

    public <T extends BaseModel> List<T> getFromEmbedded(String fieldName, Class<T> clazz){
        return _embedded.get(fieldName).stream().map(clazz::cast).collect(Collectors.toList());
    }

}
