package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;

import java.util.Collection;

@Data
public class Attraction {
    private String name;
    private String type;
    private String id;
    private Boolean test;
    private String url;
    private String locale;
    private Collection<Image> images;
    private Collection<Classification> classifications;
}
