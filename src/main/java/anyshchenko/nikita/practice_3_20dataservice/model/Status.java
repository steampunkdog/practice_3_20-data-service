package anyshchenko.nikita.practice_3_20dataservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Status implements Serializable {
    private String code;
}
