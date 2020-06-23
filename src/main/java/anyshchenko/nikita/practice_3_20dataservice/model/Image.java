package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Image implements Serializable {
    private String ratio;
    private String url;
    private Integer width;
    private Integer height;
    private Boolean fallback;
}
