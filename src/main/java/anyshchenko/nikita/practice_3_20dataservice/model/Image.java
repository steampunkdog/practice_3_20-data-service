package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;

@Data
public class Image {
    private String ratio;
    private String url;
    private Integer width;
    private Integer height;
    private Boolean fallback;
}
